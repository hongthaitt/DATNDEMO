package starter.steps;

import starter.steps.serenity.LoginEndUserSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginStepdefs {
    @Steps
    LoginEndUserSteps loginEndUserSteps;

    @Then("^User logs in \"([^\"]*)\" and return message is \"([^\"]*)\"$")
    public void userLogsInAndReturnMessageIs(String result, String message) {
        if (result.equals("pass")) {
            loginEndUserSteps.verifyLoginSuccessfully();
        } else if (result.equals("fail")) {
            loginEndUserSteps.verifyLoginFail(message);
        }
    }


    @Then("^User should see an error is \"([^\"]*)\" in \"([^\"]*)\"$")
    public void userShouldSeeAnErrorIsIn(String error, String field) {
        loginEndUserSteps.verifyInvalidField(error, field);


    }


//    @Then("^User should see an error is \"([^\"]*)\" in email field$")
//    public void userShouldSeeAnErrorIsInEmailField(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
