package starter.pages;

import starter.dataService.TestDataService;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    public void verifyPassMessage(String message) {
        String xpath = TestDataService.properties.getProperty("signUpSuccess");
        Assert.assertTrue(getDriver().findElement(By.xpath(xpath)).getText().equals(message));
    }

    public void verifyFailMessage(String message) {
        String xpath = TestDataService.properties.getProperty("errorSignUp");
        Assert.assertTrue(getDriver().findElement(By.xpath(xpath)).getText().equals(message));
    }

//    public void verifyRegisterPassDatabase() {
//        String DB_URL = TestDataService.properties.getProperty("DB_URL");
//        String USER_NAME = TestDataService.properties.getProperty("USER_NAME");
//        String PASSWORD = TestDataService.properties.getProperty("PASSWOrD");
//        try {
//            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//            Statement stmt = conn.createStatement();
//            String sql = "select first_name, last_name from customers where email =";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            conn.close();
//        } catch (
//                Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
