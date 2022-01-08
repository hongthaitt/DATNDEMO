package starter.pages;

import starter.dataService.TestDataService;
import starter.objects.Product;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static starter.databaseHelper.ConnectionDB.getConnection;

public class CartPage extends PageObject {
    public static String key;
    CommonPage commonPage;
    Homepage homepage;
    ListProductPage listProductPage;
    String DB_URL = TestDataService.properties.getProperty("DB_URL");
    String USER_NAME = TestDataService.properties.getProperty("USER_NAME");
    String PASSWORD = TestDataService.properties.getProperty("PASSWORD");

    public void clickViewCartShopping() {
        String viewCartXpath = TestDataService.properties.getProperty("viewShoppingCart");
        getDriver().findElement(By.xpath(viewCartXpath)).click();
        commonPage.waitAboutSecond(4);
    }

    public void removeCart() {
        String xpath = TestDataService.properties.getProperty("listRemove");
        commonPage.waitUntilHTMLReady(30);
        ArrayList<WebElement> listRemove = new ArrayList<>(getDriver().findElements(By.xpath(xpath)));
        System.out.println("remove ");
        String removeBtn = TestDataService.properties.getProperty("xpathRemoveBtn");

        for (int i = 1; i <= listRemove.size(); i++) {
            commonPage.waitAboutSecond(2);
            getDriver().findElement(By.xpath(removeBtn)).click();
            // element.click();
            commonPage.waitAboutSecond(10);
            getDriver().switchTo().alert().accept();
            commonPage.waitAboutSecond(2);
            commonPage.verifyMessageAlert("Success! Item was removed successfully from the cart..", "messageRemove");
//            String expectMess = TestDataService.properties.getProperty("messageRemove");
//
//            commonPage.waitUntilElementIsVisible(expectMess);
//            String mess = getDriver().findElement(By.xpath(expectMess)).getText();
//            Assert.assertTrue(mess.contains("Success!"));
            commonPage.waitUntilHTMLReady(50);
            System.out.println("cart size: " + listRemove.size());
            System.out.println("remove 1 ");

        }
    }

//    public List<String> getListProductName() {
//        String listPrdCart = TestDataService.properties.getProperty("listPrdCart");
//        List<WebElement> listProduct = new ArrayList<>(getDriver().findElements(By.xpath(listPrdCart)));
//        List<String> listProductName = new ArrayList<>();
//        for (WebElement i : listProduct) {
//            String listNameItem = i.getText();
//            System.out.println(" ten sp trong cart: " + listNameItem);
//            listProductName.add(listNameItem);
//        }
//        return listProductName;
//    }


//    public List<String> getListProductPrice() {
//        String listPrdCart = TestDataService.properties.getProperty("listPrdPrice");
//        List<WebElement> listProduct = new ArrayList<>(getDriver().findElements(By.xpath(listPrdCart)));
//        List<String> listProductPrice = new ArrayList<>();
//        for (WebElement i : listProduct) {
//            String listPriceItem = i.getText();
//            System.out.println("price trong cart: " + listPriceItem);
//            listProductPrice.add(listPriceItem);
//        }
//        return listProductPrice;
//
//    }

    public List<String> getListProductQty() {
        String listPrdCart = TestDataService.properties.getProperty("listPrdQtyCart");
        List<WebElement> listProduct = new ArrayList<>(getDriver().findElements(By.xpath(listPrdCart)));
        List<String> listProductQty = new ArrayList<>();
        for (WebElement i : listProduct) {
            String listQtyItem = i.getAttribute("value");
            System.out.println(" qty sp trong cart: " + listQtyItem);
            listProductQty.add(listQtyItem);
        }
        return listProductQty;
    }

    public List<Product> getProductInfo() {
        List<Product> listProduct = new ArrayList<>();
        List<String> listProductName = commonPage.getListProduct("listPrdNameCart");
        System.out.println("list product name size" + listProductName.size());
        List<String> listProductQty = getListProductQty();
        List<String> listProductPrice = commonPage.getListProduct("listPrdPriceCart");
        for (int i = 0; i < listProductName.size(); i++) {
            String name = listProductName.get(i);
            String price = listProductPrice.get(i);
            String qty = listProductQty.get(i);
            listProduct.add(new Product(name, price, qty, ""));
        }

        return listProduct;

    }


    public List<Product> verifyDatabaseInCart() {
        String email = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('key')");
        System.out.printf("Key:" + email);

        List<Product> listProduct = new ArrayList<>();
        if (email != null) {
            key = "notNull";

        String sql = "SELECT cart_items.name, cart_items.total, cart_items.quantity" +
                " FROM cart, cart_items " +
                "WHERE cart.customer_email= '" + email + "' " +
                "AND cart.id= cart_items.cart_id " +
                " AND cart.shipping_method IS NULL ";
        System.out.println("sql:" + sql);
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("total");
                String qty = rs.getString("quantity");
                String priceCustomize = "$" + price.substring(0, price.length() - 2);
                listProduct.add(new Product(name, priceCustomize, qty, ""));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
        else {
            key= "null";
            System.out.println("NOt to check DB ");
        }
        return listProduct;
    }
}



