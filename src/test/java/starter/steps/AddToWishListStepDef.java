package starter.steps;


import io.cucumber.datatable.DataTable;
import starter.pages.CommonPage;
import starter.steps.serenity.AddProductToCartEndUserSteps;
import starter.steps.serenity.AddToWishListEndUserStep;
import io.cucumber.java.en.*;
import io.cucumber.java.*;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class AddToWishListStepDef {
    @Steps
    AddToWishListEndUserStep addToWishList;
    CommonPage commonPage;
    AddProductToCartEndUserSteps addToCart;

    @When("^User remove wishlist$")
    public void userRemoveWishlist() {
        addToWishList.userRemoveWishlist();


    }

    @When("^User searches product and adds the first item in list result to wishlist$")
    public void userSearchesProductAndAddsTheFirstItemInListResultToWishlist(DataTable dt) {
        List<Map<String, String>> listKeys = dt.asMaps(String.class, String.class);
        Map<String, String> prd;
        for (int i = 0; i < listKeys.size(); i++) {
            prd = listKeys.get(i);
            addToWishList.userSearcheProduct(prd.get("product"));
            addToWishList.userChoosesFirstProduct();
            addToWishList.verifyNavigationToProductDetail_page();
            addToWishList.userChoosesToAddToWishList();
        }

    }

    @Then("^Products in wishlist should be displayed$")
    public void productsInWishlistShouldBeDisplayed(DataTable dt) {
        addToWishList.userClickWishList();
        List<Map<String, String>> cart = dt.asMaps(String.class, String.class);
        Map<String, String> product;
        for (int i = 0; i < cart.size(); i++) {
            product = cart.get(i);
            addToWishList.verifyInformationProductInWishList(product.get("productName"), product.get("price"), i);
            addToWishList.verifyDatabaseInWishList(product.get("productName"), product.get("price"), i);
        }
    }


}
