package starter.pages;

import org.openqa.selenium.*;
import starter.dataService.TestDataService;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.google.com/")
public class CommonPage extends PageObject {
    // common page :  funtion common in project
    //go to url

    public void goToUrl(String loginPage) {
        String loginPageUrl = TestDataService.properties.getProperty(loginPage);
        System.out.println("tesst: "+loginPageUrl);
        getDriver().get(loginPageUrl);
        getDriver().manage().window().maximize();

    }

    //clear cache
    public void clearCache() {
        getDriver().manage().deleteAllCookies();
    }

    //insert text in to field
    public void insertIntoField(String value, String xpath) {
        waitAboutSecond(2);
        String emailLoginXpath = TestDataService.properties.getProperty(xpath);
        if (emailLoginXpath == null) {
            emailLoginXpath = xpath;
        }
        getDriver().findElement(By.xpath(emailLoginXpath)).sendKeys(value);
    }

    //click on button
    public void clickOnButton(String button) {
        String buttonXpath = TestDataService.properties.getProperty(button);
        if (buttonXpath == null) {
            buttonXpath = button;
        }
        getDriver().findElement(By.xpath(buttonXpath)).click();
        waitAboutSecond(5);
    }
public void enter(){
    getDriver().findElement(By.id("Value")).sendKeys(Keys.RETURN);
}
    public void waitUntilElementIsVisible(String button) {
        String xpath = TestDataService.properties.getProperty(button);
        if (xpath == null) {
            xpath = button;
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    //wait by condition
    public void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyUrlNavigate(String url) {
        String urlExpect = TestDataService.properties.getProperty(url);
        if (urlExpect == null) {
            urlExpect = url;
        }
        Assert.assertEquals(urlExpect, getDriver().getCurrentUrl());

    }

    public void waitUntilHTMLReady(int timeoutInSeconds) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofDays(timeoutInSeconds));
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                ;
                return ((Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
            } catch (Exception e) {
                return true;
            }
        };
        wait.until(jQueryLoad);

        wait.until((ExpectedCondition<Boolean>) d -> {
            try {
                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
            } catch (Exception e) {
                return false;
            }
        });
    }


    public void scrollOnButtomPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,250)");
    }

    public void waitAboutSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleareLocalStorage() {
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.clear()");
    }

    public void verifyMessageAlert(String message, String xpathMessage) {
        String xpath = TestDataService.properties.getProperty(xpathMessage);
        String messageCurrent = getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(message.equals(messageCurrent.substring(2, messageCurrent.length())));
    }

    //    public List<String> getListProduct(String xpath) {
//        String listPrdCart = TestDataService.properties.getProperty(xpath);
//        List<WebElement> listProduct = new ArrayList<>(getDriver().findElements(By.xpath(listPrdCart)));
//        List<String> listProductQty = new ArrayList<>();
//        for (WebElement i : listProduct) {
//            String listQtyItem = i.getAttribute("value");
//            System.out.println(" qty sp trong cart: " + listQtyItem);
//            listProductQty.add(listQtyItem);
//        }
//        return listProductQty;
//    }
    public List<String> getListProduct(String xpath) {
        String listPrdCart = TestDataService.properties.getProperty(xpath);
        List<WebElement> listProduct = new ArrayList<>(getDriver().findElements(By.xpath(listPrdCart)));
        List<String> listProductName = new ArrayList<>();
        for (WebElement i : listProduct) {
            String listNameItem = i.getText();
            System.out.println(" ten sp trong cart: " + listNameItem);
            listProductName.add(listNameItem);
        }
        return listProductName;
    }

    public String getText(String xpath) {
        String xpathText = TestDataService.properties.getProperty(xpath);
        if (xpathText == null) {
            xpathText = xpath;
        }
        String textCurrent = getDriver().findElement(By.xpath(xpathText)).getText();
        return textCurrent;
    }

    public void saveToLocalStoregaeWithName(String username, String key) {
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.setItem('" + key + "','" + username + "')");
    }

    public void userShouldSeeMessage(String message) {
        System.out.println("message: "+message);
        String expectMessXpath = TestDataService.properties.getProperty("messageRemove");
        //waitUntilElementIsVisible(expectMessXpath);
        //waitAboutSecond(12);
        String messageCurrent = getDriver().findElement(By.xpath(expectMessXpath)).getText();
        System.out.println("messcurrent: "+messageCurrent);
        Assert.assertTrue(message.equals(messageCurrent.substring(2, messageCurrent.length())));
    }
    public void selectAndChooseValue(String dropdown, String value) {
        String xpath = TestDataService.properties.getProperty(dropdown);
        if (xpath == null) {
            xpath = dropdown;
        }
        String valueChoose = TestDataService.properties.getProperty(value);
        if (valueChoose == null) {
            valueChoose = value;
        }
        WebElement dropdownTest = getDriver().findElement(By.xpath(xpath));
        Select dr = new Select(dropdownTest);
        dr.selectByVisibleText(valueChoose);
    }
    public void verifyText(String text, String xpath) {
        waitAboutSecond(3);
        String xpathOfTitle = TestDataService.properties.getProperty(xpath);
        System.out.println("Text"+getDriver().findElement(By.xpath(xpathOfTitle)).getText());
        //ssert.assertEquals(text, getDriver().findElement(By.xpath(xpathOfTitle)).getText());
        Assert.assertTrue(getDriver().findElement(By.xpath(xpathOfTitle)).getText().contains(text));
    }
}



