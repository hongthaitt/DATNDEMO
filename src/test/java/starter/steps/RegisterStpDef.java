package starter.steps;

import starter.steps.serenity.RegisterEndUserSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class RegisterStpDef {
    @Steps
    RegisterEndUserSteps registerEndUserSteps;

    @Then("^User sign up \"([^\"]*)\" and should see a message is \"([^\"]*)\"$")
    public void userSignUpAndShouldSeeAMessageIs(String result, String message) {
        if (result.equals("pass")) {
            registerEndUserSteps.verifyPassMessage(message);
            //registerEndUserSteps.verifyRegisterPassDatabase();
        } else if (result.equals("fail")) {
            registerEndUserSteps.verifyFailMessage(message);
            //registerEndUserSteps.verifyRegisterFailDatabase();
        }
    }
}
