package starter.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.dataService.TestDataService;
import starter.steps.serenity.AddProductToCartEndUserSteps;
import starter.steps.serenity.OrderEndUser;

import java.util.List;
import java.util.Map;

public class OrderStepDef {
    @Steps
    OrderEndUser order;
    @Steps
    AddProductToCartEndUserSteps addToCart;
    @Before
    public void beforeScenario() {
        if (TestDataService.properties == null) {
            //run with ubuntu, need set path to /
            //TestDataService.setProperties("/src/test/resources/data_test/data.properties");
            //run with windows, need set path to \\
            TestDataService.setProperties("\\src\\test\\resources\\data_test\\data.properties");
        }
    }
    @And("User checkout")
    public void userCheckout() {
        order.checkOut();
    }

    @When("User inserts information to buy product")
    public void userInsertsInformationToBuyProduct(DataTable dataTable) {
        List<Map<String, String>> dataTables = dataTable.asMaps(String.class, String.class);
        Map<String, String> bill ;
        for (int i = 0; i < dataTables.size(); i++) {
            bill = dataTables.get(i);
            switch (bill.get("firstName")) {
                case "validFN":
                    order.insertFirstname("Thai");
                    break;
                case "space":
                    order.insertFNEnter("      ");


            }

            switch (bill.get("lastName")) {
                case "validLN":
                    order.insertLastname("Hong");
                    break;
            }
            switch (bill.get("email")) {
                case "validE":
                    order.insertEmail("hongthai1666@gmail.com");
                    break;
            }
            switch (bill.get("streetAddress")) {
                case "validSA":
                    order.insertStresstAdd("33/108 CG");
                    break;
            }
            switch (bill.get("city")) {
                case "validCity":
                    order.insertCity("Ha noi");
                    break;
            }
            switch (bill.get("country")) {
                case "validC":
                    order.selectAndChooseValue("countryBill", "Vietnam");
            }
            switch (bill.get("state")) {
                case "validState":
                    order.insertState("CG");

            }
            switch (bill.get("zipCode")) {
                case "validZip":
                    order.insertZipCode("1000");
                    break;
            }
            switch (bill.get("telephone")) {
                case "validTele":
                    order.insertTelephone("0981285734");
                    break;

            }
            switch (bill.get("shippingMethod")) {
                case "freeShipping":
                    order.chooseShippingmethod("freeBtn");
                    order.getTotalOfBill("freeShiping");
                    break;
                case "flatShipping":
                    order.chooseShippingmethod("flatRateBtn");
                    order.getTotalOfBill("flatShipping");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("payment")) {
                case "cashOnDelivery":
                    order.choosePayment("cashOnDelivery");
                    break;
                case "moneyTransfer":
                    order.choosePayment("moneyTransfer");
                    break;
                case "null":
                    break;

            }
            switch (bill.get("coupon")) {
                case "no":
                    break;
                case "null":
                    break;
            }

        }

        order.verifyPrice();

}

    @Then("Products in cart should be displayed and user checkouts")
    public void productsInCartShouldBeDisplayedAndUserCheckouts(DataTable dt) {
        System.out.println("cos dden day lp ");
        addToCart.userClickCart();
        List<Map<String, String>> cart = dt.asMaps(String.class, String.class);
        Map<String, String> product;
        for (int i = 0; i < cart.size(); i++) {
            product = cart.get(i);
            addToCart.verifyInformationProductInCart(product.get("productName"), product.get("price"), product.get("quantity"), i);
            addToCart.verifyDatabaseInCart(product.get("productName"), product.get("price"), product.get("quantity"), i);
            order.getTotalPriceOfProduct(product.get("price"), product.get("quantity"));
        }
        order.checkOut();
    }

    @Then("User should see total and message successful.")
    public void userShouldSeeTotalAndMessageSuccessful() {
        order.placeOrder();
        order.verifyTotalInDataBase();
        order.resetVariable();
    }

//    @Then("User should see the {string}")
//    public void userShouldSeeThe(String message) {
//        order.verifyMessage(message);
//    }


    @Then("User should see the {string}")
    public void userShouldSeeThe(String message) {
        order.verifyMessage(message);
    }

    @When("User inserts information to validate")
    public void userInsertsInformationToValidate(DataTable dataTable) {
        List<Map<String, String>> dataTables = dataTable.asMaps(String.class, String.class);
        Map<String, String> bill ;
        for (int i = 0; i < dataTables.size(); i++) {
            bill = dataTables.get(i);
            switch (bill.get("firstName")) {
                case "space":
                    order.insertFNEnter("      ");
                case "null":
                    break;

            }

            switch (bill.get("lastName")) {
                case "validLN":
                    order.insertLastname("Hong");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("email")) {
                case "validE":
                    order.insertEmail("hongthai1666@gmail.com");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("streetAddress")) {
                case "validSA":
                    order.insertStresstAdd("33/108 CG");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("city")) {
                case "validCity":
                    order.insertCity("Ha noi");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("country")) {
                case "validC":
                    order.selectAndChooseValue("countryBill", "Vietnam");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("state")) {
                case "validState":
                    order.insertState("CG");
                case "null":
                    break;
            }
            switch (bill.get("zipCode")) {
                case "validZip":
                    order.insertZipCode("1000");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("telephone")) {
                case "validTele":
                    order.insertTelephone("0981285734");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("shippingMethod")) {
                case "freeShipping":
                    order.chooseShippingmethod("freeBtn");

                    break;
                case "flatShipping":
                    order.chooseShippingmethod("flatRateBtn");
                    break;
                case "null":
                    break;
            }
            switch (bill.get("payment")) {
                case "cashOnDelivery":
                    order.choosePayment("cashOnDelivery");
                    break;
                case "null":
                    break;

            }
            switch (bill.get("coupon")) {
                case "no":
                    break;
                case "null":
                    break;
            }

        }

    }



}
