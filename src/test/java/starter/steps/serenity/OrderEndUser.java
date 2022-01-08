package starter.steps.serenity;

import org.junit.Assert;
import starter.objects.Product;
import starter.pages.CartPage;
import starter.pages.CommonPage;
import starter.pages.Homepage;
import starter.pages.OrderPage;

public class OrderEndUser {
    Homepage homepage;
    OrderPage orderPage;
    CommonPage commonPage;
    CartPage cartPage;

    public void checkOut() {
        commonPage.waitAboutSecond(5);
        commonPage.clickOnButton("proceedCheckoutBtn");
    }

    public void userClickCart() {
        commonPage.waitAboutSecond(10);
        homepage.clickCartIcon();
        System.out.println("click cart r");
        commonPage.clickOnButton("checkoutBtn");
        System.out.println("click checkout roi");
    }

    public void verifyInformationProductInCart(String productName, String price, String quantity, int i) {
        Product prd = cartPage.getProductInfo().get(i);
        Assert.assertEquals(productName, prd.getNamePrdInCart());
        Assert.assertEquals(price, prd.getPricePrdInCart());
        Assert.assertEquals(quantity, prd.getQuantity());
    }
    public void insertFirstname(String value){
        commonPage.insertIntoField(value, "firstNameBill");
    }

    public void insertLastname(String value) {
        commonPage.insertIntoField(value, "lastNameBill");
    }
    public void insertEmail(String value ) {
        commonPage.insertIntoField(value, "emailBill");
    }
    public void insertStresstAdd(String value){
        commonPage.insertIntoField(value, "streetAddBill");

    }
    public void insertCity(String value){
        commonPage.insertIntoField(value, "cityBill");
    }
    public void selectAndChooseValue( String xpath,String value){
        commonPage.selectAndChooseValue(xpath, value);
    }
    public void insertState(String value){
        commonPage.insertIntoField(value, "stateBill");
    }

    public void insertZipCode(String value){
        commonPage.insertIntoField(value, "postCodeBill");
    }
    public void insertTelephone(String value){
        orderPage.specialSendkey(value, "telephoneBill");
    }
    public void insertFNEnter(String value){orderPage.specialSendkey(value, "firstNameBill");}
    public void insertLNEnter(String value){orderPage.specialSendkey(value, "lastNameBill");}
    public void chooseShippingmethod(String value){
        commonPage.waitAboutSecond(3);
       commonPage.clickOnButton(value);

    }
    public void choosePayment(String value){
        commonPage.clickOnButton(value);

    }
    public void insertCoupon(String value){
        commonPage.insertIntoField(value, "applyCouponBtn");
    }

    public void placeOrder() {
commonPage.clickOnButton("placeOrderBtn");
commonPage.waitAboutSecond(10);
commonPage.verifyText("Thank you for your order!","titleSuccess");
orderPage.getOrderId();
    }

    public void getTotalPriceOfProduct(String price, String quantity) {
        orderPage.getTotalPriceOfProduct(price,quantity);
    }

    public void getTotalOfBill(String typeShipping) {
       orderPage.getTotalOfBill(typeShipping);
        }

    public void verifyPrice() {
        orderPage.verifyPrice();
    }

    public void verifyTotalInDataBase() {
        orderPage.verifyTotalInDataBase();
    }

    public void verifyMessage(String message) {
            commonPage.verifyText(message, "errorMandatory");

    }

    public void resetVariable() {
        orderPage.resetVariable();
    }
}

