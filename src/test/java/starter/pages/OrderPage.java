package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import starter.dataService.TestDataService;
import starter.objects.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static starter.databaseHelper.ConnectionDB.getConnection;

public class OrderPage extends PageObject {
    String DB_URL = TestDataService.properties.getProperty("DB_URL");
    String USER_NAME = TestDataService.properties.getProperty("USER_NAME");
    String PASSWORD = TestDataService.properties.getProperty("PASSWORD");
    public static double total;
    public static double priceOfOrder;
    CommonPage commonPage;

    public void specialSendkey(String value, String xpath) {
        String xpathTelephone = TestDataService.properties.getProperty(xpath);
        if (xpathTelephone == null) {
            xpathTelephone = xpath;
        }
        WebElement tele = getDriver().findElement(By.xpath(xpathTelephone));
        tele.sendKeys(value);
        tele.sendKeys(Keys.ENTER);
    }

    /* Dona nay co van de ne*/
    public void getTotalPriceOfProduct(String price, String quantity) {
        commonPage.waitAboutSecond(5);
        String priceSub = price.substring(1, price.length());
        System.out.println("price sau substring: " + priceSub);
        total = total + Double.parseDouble(priceSub);
        System.out.println("tatal bao nheo: " + total);
        commonPage.saveToLocalStoregaeWithName(String.valueOf(total), "totalOfBill");
    }

    public void getTotalOfBill(String typeShipping) {

        String xpathGrandTotal = TestDataService.properties.getProperty("grandTotal");
        String price = getDriver().findElement(By.xpath(xpathGrandTotal)).getText();
        String priceSub = price.substring(1, price.length());
        if (typeShipping == "flatShipping") {
            priceOfOrder = Double.parseDouble(priceSub.replace(",", "")) + 20.0;
        } else {
            priceOfOrder = Double.parseDouble(priceSub.replace(",", ""));
        }

    }


    public void verifyPrice() {
        System.out.println("price of: " + priceOfOrder);
        System.out.println("total:" + total);
        Assert.assertEquals(String.valueOf(priceOfOrder), String.valueOf(total));

    }

    public void getOrderId() {
        String xpath = TestDataService.properties.getProperty("orderId");
        String orderIdFull = getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("caau lay dc la: " + orderIdFull);
        String orderId = orderIdFull.substring(18, orderIdFull.length());
        System.out.println("id order: " + orderId);
        commonPage.saveToLocalStoregaeWithName(orderId, "orderIDKEY");
    }

    public void verifyTotalInDataBase() {
        String total = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('totalOfBill')");
        System.out.printf("Key:" + total);
        String orderId = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('orderIDKEY')");
        System.out.println("totalBill:" + orderId);
        String sql = "SELECT grand_total \n" +
                " FROM bagisto.orders\n" +
                " WHERE id ='" + orderId + "'";
//            String sql = "SELECT cart_items.name, cart_items.total, cart_items.quantity" +
//                    " FROM cart, cart_items " +
//                    "WHERE cart.customer_email= '" + email + "' " +
//                    "AND cart.id= cart_items.cart_id " +
//                    " AND cart.shipping_method IS NULL ";
        System.out.println("sql:" + sql);
        if (orderId != null) {
            try {
                Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String grandTotal = rs.getString("grand_total");
                    System.out.println("db grand-total: " + grandTotal);
                    Assert.assertEquals(grandTotal.substring(0, grandTotal.length()-3), String.valueOf(total));
                }
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    public void resetVariable() {
        total=0;
        priceOfOrder=0;
    }
}

