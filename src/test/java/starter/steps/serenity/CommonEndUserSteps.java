package starter.steps.serenity;

import org.junit.Assert;
import starter.dataService.TestDataService;
import starter.pages.CommonPage;

public class CommonEndUserSteps {

    CommonPage commonPage;

    public void goToLoginUrl(String loginPage) {
        commonPage.clearCache();
        commonPage.goToUrl(loginPage);
        //commonPage.waitAboutSecond(120);
    }

    public void insertIntoField(String username, String emailLogin) {
        commonPage.insertIntoField(username, emailLogin);
    }

    public void clickOnButton(String button) {
        commonPage.clickOnButton(button);


    }



    public void verifyUrlNavigate(String url) {
        commonPage.verifyUrlNavigate(url);
    }

    public void scrollOnButtomPage() {
        commonPage.scrollOnButtomPage();

    }


    public void saveToLocalStoregaeWithName(String username, String key) {
        commonPage.saveToLocalStoregaeWithName(username, key);
    }

    public void cleareLocalStorage() {
        commonPage.cleareLocalStorage();

    }

    public void userShouldSeeMessage(String message) {
        commonPage.userShouldSeeMessage(message);
    }
    public void userLoginWithUsernameAndPW(String username, String password) {
        commonPage.waitAboutSecond(5);
        commonPage.clickOnButton("guestBtn");
        commonPage.clickOnButton("signInBtn");
        commonPage.verifyUrlNavigate("loginPage");
        commonPage.insertIntoField(username, "emailLogin");
        commonPage.saveToLocalStoregaeWithName(username, "key");
        commonPage.insertIntoField(password, "passwordLogin");
        commonPage.clickOnButton("loginButton");
    }
}



