package starter.steps.serenity;

import starter.pages.RegisterPage;

public class RegisterEndUserSteps {
    RegisterPage registerPage;

    public void verifyPassMessage(String message) {
        registerPage.verifyPassMessage(message);
    }

    public void verifyFailMessage(String message) {
        registerPage.verifyFailMessage(message);
    }

//    public void verifyRegisterPassDatabase() {
//        registerPage.verifyRegisterPassDatabase();
//    }
}
