package starter.pages;

import starter.dataService.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public void verifyLoginSuccessfully() {
        Assert.assertEquals("http://127.0.0.1:8000/customer/account/profile", getDriver().getCurrentUrl());
    }

    public void verifyLoginFail(String message) {
        String messageXpath = TestDataService.properties.getProperty("loginFail");
        Assert.assertTrue(getDriver().findElement(By.xpath(messageXpath)).getText().contains(message));

    }


    public void verifyINvalidField(String error, String field) {
        String xpath = TestDataService.properties.getProperty(field);
        Assert.assertTrue(getDriver().findElement(By.xpath(xpath)).getText().contains(error));
    }
}
