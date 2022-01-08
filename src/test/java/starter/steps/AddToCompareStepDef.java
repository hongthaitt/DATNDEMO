package starter.steps;

import starter.pages.CommonPage;
import starter.steps.serenity.AddToCompareEndUserStep;
import io.cucumber.java.en.*;
import io.cucumber.java.*;
import net.thucydides.core.annotations.Steps;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class AddToCompareStepDef {
    @Steps
    AddToCompareEndUserStep addToCompare;
    CommonPage commonPage;
    @When("^User remove product in compare list$")
    public void userRemoveProductInCompareList() {
        addToCompare.userRemoveProductInCompareCart();

    }

    @When("^User searches product and adds the first item in list result to compare cart$")
    public void userSearchesProductAndAddsTheFirstItemInListResultToCompareCart(DataTable dt) {
        List<Map<String, String>> listKeys = dt.asMaps(String.class, String.class);
        Map<String, String> prd;
        for (int i = 0; i < listKeys.size(); i++) {
            prd = listKeys.get(i);
            addToCompare.userSearcheProduct(prd.get("product"));
            addToCompare.userChoosesFirstProduct();
            addToCompare.verifyNavigationToProductDetail_page();
            addToCompare.userChoosesToAddToCompareList();
        }

    }

    @Then("^Products in compare cart should be displayed$")
    public void productsInCompareCartShouldBeDisplayed(DataTable dt) {
        List<Map<String, String>> compare = dt.asMaps(String.class, String.class);
        Map<String, String> product;
        for (int i = 0; i < compare.size(); i++) {
            product = compare.get(i);
            addToCompare.verifyInformationProductInCompareCart(product.get("productName"), product.get("price"), product.get("description"), i);
            addToCompare.verifyDatabaseInCompareCart(product.get("productName"), product.get("price"), product.get("description"), i);
        }
    }

    @When("^User adds first product into cart$")
    public void userAddsFirstProductIntoCart() {
        addToCompare.userAddsFirstProductIntoCart();
    }

    @When("^User remove first product in compare list$")
    public void userRemoveFirstProductInCompareList() {
        addToCompare.userRemoveFirstProductInCompareList();
    }

    @And("^User clicks on Compare cart$")
    public void userClicksOnCompareCart() {
        addToCompare.clickCompareCart();
    }

    @And("^User clicks on Profile and chooses Compare$")
    public void userClicksOnProfileAndChoosesCompare() {
        addToCompare.userClicksOnProfileAndChoosesCompare();
    }


    @When("^User move first product to wishlist$")
    public void userMoveFirstProductToWishlist() {
        addToCompare.userMoveFirstProductToWishlist();
    }

    @Then("^User move first product to wishlist and page navigates to login page$")
    public void userMoveFirstProductToWishlistAndPageNavigatesToLoginPage() {
        addToCompare.userMoveFirstProductToWishlistAndPageNavigatesToLoginPage();
    }
}
