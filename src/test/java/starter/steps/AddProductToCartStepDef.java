package starter.steps;

import starter.dataService.TestDataService;
import starter.steps.serenity.AddProductToCartEndUserSteps;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;
import io.cucumber.java.en.*;
import io.cucumber.java.*;
public class AddProductToCartStepDef {
    @Steps
    AddProductToCartEndUserSteps addToCart;
    @Before
    public void beforeScenario() {
        if (TestDataService.properties == null) {
            //run with ubuntu, need set path to /
            //TestDataService.setProperties("/src/test/resources/data_test/data.properties");
            //run with windows, need set path to \\
            TestDataService.setProperties("src\\test\\resources\\data_test\\data.properties");

        }
    }
    @When("^User searches product and adds the first item in list result to cart$")
    public void userSearchesProductAndAddsTheFirstItemInListResultToCart(DataTable dt) {
        List<Map<String, String>> listKeys = dt.asMaps(String.class, String.class);
        Map<String, String> prd;
        for (int i = 0; i < listKeys.size(); i++) {
            prd = listKeys.get(i);
            addToCart.userSearcheProduct(prd.get("product"));
//            addToCart.verify_navigation_to_listProduct_page(prd.get("expectedTitle"));
            addToCart.userChoosesFirstProduct();
            addToCart.verifyNavigationToProductDetail_page();
            addToCart.userChoosesToBuyProductWithQuantity(prd.get("quantity"));
            String message = prd.get("message");
            switch (message){
                case "Warning! The requested quantity is not available, please try again later..":
                    addToCart.userSeesTheErrorMessage(prd.get("message"));
                    break;
                case "Success! Item was successfully added to cart..":
                addToCart.userSeesTheSuccessMessage(prd.get("message"));
                break;
            }

        }
    }

    @When("^User remove cart$")
    public void userRemoveCart() {
        addToCart.userRemoveCart();
    }

    @Then("^Products in cart should be displayed$")
    public void productsInCartShouldBeDisplayed(DataTable dt) {
        addToCart.userClickCart();
        List<Map<String, String>> cart = dt.asMaps(String.class, String.class);
        Map<String, String> product;
        for (int i = 0; i < cart.size(); i++) {
            product = cart.get(i);
            addToCart.verifyInformationProductInCart(product.get("productName"), product.get("price"), product.get("quantity"), i);
            addToCart.verifyDatabaseInCart(product.get("productName"), product.get("price"), product.get("quantity"), i);
        }
    }

    //latnho xoa cai nay
    @Then("^User add product in homepage to cart$")
    public void userAddProductInHomepageToCart() {
        addToCart.clickAddtoCartBtn();
    }

    @And("^User clicks continue shopping$")
    public void userClicksContinueShopping() {
        addToCart.userClicksContinueShopping();
    }


    @And("^User continues to add a same product$")
    public void userContinuesToAddASameProduct() {
        addToCart.contunueAddSameProduct();
    }


}
