package starter.pages;

import starter.dataService.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Homepage extends PageObject {
    CommonPage commonPage;
    public static String prdName;
    public static String prdPrice;

    public void searchProduct(String productName) {
        //get xpath of search field

        String searchFieldXpath = TestDataService.properties.getProperty("nameProductToSearch");
        //get xpath of search button

        String buttonSearchXpath = TestDataService.properties.getProperty("searchButton");
        // input name product and click search button

        commonPage.waitUntilHTMLReady(50);
        getDriver().findElement(By.xpath(searchFieldXpath)).sendKeys(productName);
        getDriver().findElement(By.xpath(buttonSearchXpath)).click();
        commonPage.waitUntilHTMLReady(50);

    }


    public void clickCartIcon() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        commonPage.waitAboutSecond(5);
        String xpath = TestDataService.properties.getProperty("cartBtn");
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public boolean checkQtyCart() {
        //Boolean display;
        String xpath = TestDataService.properties.getProperty("iconQtyCart");
        System.out.println("xpath: " + xpath);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<WebElement> listSpan = new ArrayList<>(getDriver().findElements(By.xpath(xpath)));
        System.out.printf("size: " + listSpan.size());
        if (listSpan.size() == 2) {
            return true;
        } else
            return false;


    }

    public void clickAddToCart() {
        commonPage.scrollOnButtomPage();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//*[@id=\"fearured-products-carousel\"]/div[1]/div/div[1]/div/div/div[5]/div/form/button/span")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String messs = getDriver().findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']")).getText().contains("Success! Item was successfully added to cart.."));
        System.out.println(" so sanh xong");
    }

    public void userClickUploadFile() {
        WebElement addFile = getDriver().findElement(By.xpath("//i[@class='icon camera-icon']"));
        addFile.click();
        addFile.sendKeys("D:/autotest/HocGit/push1.txt");

    }
}
