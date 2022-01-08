package starter.pages;

import starter.dataService.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static starter.databaseHelper.ConnectionDB.getConnection;

public class ListProductPage extends PageObject {
    //get db_url, username , password from file properties
    String DB_URL = TestDataService.properties.getProperty("DB_URL");
    String USER_NAME = TestDataService.properties.getProperty("USER_NAME");
    String PASSWORD = TestDataService.properties.getProperty("PASSWORD");
    public static String expectedPrdName;
    public static String expectedPrdPrice;
    CommonPage commonPage;

    public void verifyListProduct(String productName) {
        //sql query product with name = product name
        String sql = "SELECT name FROM product_flat WHERE name LIKE '%" + productName + "%';";

        //get xpath list product
        String listProductResultXpath = TestDataService.properties.getProperty("listProductResult");
        commonPage.waitUntilElementIsVisible(listProductResultXpath);
        //define arraylist xpath of list product
        ArrayList<WebElement> listProductName = new ArrayList<>(getDriver().findElements(By.xpath(listProductResultXpath)));

        //define a arraylist to contain name product in database
        ArrayList<String> resultSetList = new ArrayList<>();
        //connect database , add product into resulSetList
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                resultSetList.add(rs.getString(1));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //compare two product in two arraylist
        if (resultSetList.size() == listProductName.size() && resultSetList.size() != 0) {
            int i = 0;
            for (WebElement element : listProductName) {
                Assert.assertEquals(element.getText(), resultSetList.get(i));
                i++;
            }
        }
        System.out.println("da qua day ruis");
    }

    public void verifyNoResultProduct(String productName) {
        String sql = "SELECT name FROM product_flat WHERE name LIKE '%" + productName + "%';";
        ArrayList<String> resultSetList = new ArrayList<>();
        String xpath = TestDataService.properties.getProperty("noResult");
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                resultSetList.add(rs.getString(1));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (resultSetList.size() == 0) {

            Assert.assertEquals(getDriver().findElement(By.xpath(xpath)).getText(), "No Results Found");
        }
    }

    public void userChoosesFirstProduct() {

        String xpath = TestDataService.properties.getProperty("firstPrdName");
        commonPage.waitAboutSecond(30);
        getDriver().findElement(By.xpath(xpath)).click();
        System.out.println("click xong ");


    }

    public void getExpectedProductInfo() {
        commonPage.waitAboutSecond(30);
        String firstPrdNameXpath = TestDataService.properties.getProperty("firstPrdName");
        String firstProductPriceXpath = TestDataService.properties.getProperty("firstProductPrice");
        expectedPrdName = getDriver().findElement(By.xpath(firstPrdNameXpath)).getAttribute("title");
        System.out.println("expect name: " + expectedPrdName);
        expectedPrdPrice = getDriver().findElement(By.xpath(firstProductPriceXpath)).getText();
        System.out.println("expect name: " + expectedPrdPrice);
    }
}
