package starter.steps;

import starter.steps.serenity.SearchProductEndUserSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

import java.sql.SQLException;

public class SearchProductStepDef {
    @Steps
    SearchProductEndUserSteps searchProductEndUserSteps;

    @And("^User searches \"([^\"]*)\" and verify \"([^\"]*)\" display$")
    public void userSearchesAndVerifyDisplay(String productName, String result) throws SQLException {
        if (result.equals("have result")) {
            searchProductEndUserSteps.verifyListProduct(productName);
        }
        if (result.equals("no result")) {
            searchProductEndUserSteps.verifyNoResultProduct(productName);
        }
    }

    @Then("^user click upload file$")
    public void userClickUploadFile() {
        searchProductEndUserSteps.userClickUploadFile();
    }
}

