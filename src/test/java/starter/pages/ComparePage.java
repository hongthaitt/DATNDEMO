package starter.pages;

import starter.dataService.TestDataService;
import starter.objects.Product;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static starter.databaseHelper.ConnectionDB.getConnection;

public class ComparePage extends PageObject {
    CommonPage commonPage;
    String DB_URL = TestDataService.properties.getProperty("DB_URL");
    String USER_NAME = TestDataService.properties.getProperty("USER_NAME");
    String PASSWORD = TestDataService.properties.getProperty("PASSWORD");
    public static  String key;
    public void userRemoveProductInCompareCart() {

        String xpathListProduct = TestDataService.properties.getProperty("listPrdCompare");
        ArrayList<WebElement> listPrd = new ArrayList<WebElement>(getDriver().findElements(By.xpath(xpathListProduct)));
        if (listPrd.size() == 1) {
            System.out.println("No product in compare");
        } else {
            commonPage.waitAboutSecond(10);
            commonPage.clickOnButton("compareDeleteAll");
            commonPage.waitAboutSecond(2);
            String messageSuccess = "Success! All Items successfully removed from compare list.";
            commonPage.verifyMessageAlert(messageSuccess, "messageRemove");
            commonPage.clickOnButton("closeMessageBtn");
            commonPage.waitAboutSecond(2);
            String textInNullCompareList= commonPage.getText("noItemInCompareList");
            System.out.println("text compare: "+textInNullCompareList);
            Assert.assertTrue(textInNullCompareList.equals("You don't have any items in your compare list"));
            System.out.println("delete compare list  done");
        }
    }

    public List<Product> getProductInfo() {
        List<Product> listProduct = new ArrayList<>();
        List<String> listPrdName = commonPage.getListProduct("listPrdNameCP");
        List<String> listPrdPrice = commonPage.getListProduct("listPrdPriceCP");
        List<String> listPrdDes = commonPage.getListProduct("listPrdDesCP");
        for (int i = 0; i < listPrdName.size(); i++) {
            String name = listPrdName.get(i);
            String price = listPrdPrice.get(i);
            String des = listPrdDes.get(i);
            System.out.println("dess:" + des);
            listProduct.add(new Product(name, price, "", des));
        }
        return listProduct;
    }

    public void verifTitleInCompareCart() {
        Assert.assertEquals("Name", commonPage.getText("nameTitleCP"));
        Assert.assertEquals("Product Image", commonPage.getText("prdImageTitleCP"));
        Assert.assertEquals("Actions", commonPage.getText("actionTitleCP"));
        Assert.assertEquals("Description", commonPage.getText("desTitleCP"));
        Assert.assertEquals("Price", commonPage.getText("priceTitleCP"));
        System.out.println("done verify title in compare table");

    }

    public List<Product> verifyDatabaseInCompareCart() {
        String email = (String) ((JavascriptExecutor) getDriver()).executeScript("return localStorage.getItem('key')");
        System.out.println("key tim dc la: "+ email);
        List<Product> listPrd = new ArrayList<>();
        if(email!=null) {
            key= "notNull";
            String sql = "SELECT product_flat.name, product_flat.price, product_flat.description" +
                    " FROM product_flat, customers, velocity_customer_compare_products " +
                    "WHERE customers.email= '" + email + "'" +
                    "AND customers.id=velocity_customer_compare_products.customer_id" +
                    " AND velocity_customer_compare_products.product_flat_id= product_flat.id";

//                " SELECT product_flat.name, product_flat.price, product_flat.description"+
//        "FROM product_flat, customers, velocity_customer_compare_products"+
//                "WHERE customers.email= '"+ email + "'"  +
//       " AND customers.id=velocity_customer_compare_products.customer_id"+
//        "AND velocity_customer_compare_products.product_flat_id= product_flat.id";
//
//        "SELECT product_flat.name, product_flat.price, product_flat.description" +
//                " FROM product_flat, customers, velocity_customer_compare_products " +
//                "WHERE customers.email= '"+ email + "'"  +
//                "AND customers.id=velocity_customer_compare_products.customer_id" +
//                " AND velocity_customer_compare_products.product_flat_id= product_flat.id";
            try {
                Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString("name");
                    String price = rs.getString("price");
                    String priceCustomize = "$" + price.substring(0, price.length() - 2);
                    String description = rs.getString("description");
                    //System.out.println("check des trng db : "+description);
                    System.out.println("cbi cut string");
                    description = description.replaceAll("\\<.*?\\>", "");
                    description = description.replaceAll("&nbsp;", " ");
                    System.out.println("cbi cut string" + description);
                    listPrd.add(new Product(name, priceCustomize, "", description));
                }
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            key= "null";
            System.out.println("no check DB ");
        }
        return listPrd;
    }

    public void userAddsFirstProductIntoCart() {
        commonPage.clickOnButton("addToCartBtnCP");
        commonPage.waitAboutSecond(2);
        String message= "Success! Item was successfully added to cart..";
        commonPage.verifyMessageAlert(message,"messageRemove");
        System.out.println("add first prd in compare list to cart");
    }

    public void userRemoveFirstProductInCompareList() {
    commonPage.clickOnButton("removePrdInCompare");
    commonPage.waitAboutSecond(2);
    commonPage.verifyMessageAlert("Success! Item successfully removed from compare list.","messageRemove");
        System.out.println("done delete 1 prd in compare list");
    }

    public void userMoveFirstProductToWishlist() {
    }

    public void verifyIconHeartMoveToBorder() {
      String text=   commonPage.getText("borderIconHeart");
        Assert.assertTrue(text.equals("favorite"));
    }
}
