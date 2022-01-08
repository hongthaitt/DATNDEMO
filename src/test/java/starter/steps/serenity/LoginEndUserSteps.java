package starter.steps.serenity;

import starter.pages.CommonPage;
import starter.pages.LoginPage;

public class LoginEndUserSteps {
    LoginPage loginPage;
    CommonPage commonPage;

    public void verifyLoginSuccessfully() {
        loginPage.verifyLoginSuccessfully();
        commonPage.clickOnButton("homeButton");
    }

    public void verifyLoginFail(String message) {

        loginPage.verifyLoginFail(message);
        commonPage.clickOnButton("homeButton");
    }

    public void verifyInvalidField(String error, String field) {
        loginPage.verifyINvalidField(error, field);
    }
}
