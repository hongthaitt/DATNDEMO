package starter.steps.serenity;

import starter.objects.Product;
import starter.pages.*;
import org.junit.Assert;

import static starter.pages.ComparePage.key;
import static starter.pages.DetailProductPage.prdName;
import static starter.pages.DetailProductPage.prdPrice;
import static starter.pages.ListProductPage.expectedPrdName;
import static starter.pages.ListProductPage.expectedPrdPrice;

public class AddToCompareEndUserStep {
    // use xpath, check if element if unique, no item in compare cart, continue step
    //else have  products , then click delete all button
    ComparePage comparePage;
    CommonPage commonPage;
    Homepage homepage;
    ListProductPage listProductPage;
    DetailProductPage detailProductPage;

    public void userRemoveProductInCompareCart() {
        commonPage.waitAboutSecond(2);
        commonPage.clickOnButton("compareBtn");
        comparePage.userRemoveProductInCompareCart();

    }

    public void userSearcheProduct(String product) {
        System.out.printf("Product name to search: " + product);
        homepage.searchProduct(product);
        listProductPage.verifyListProduct(product);
    }

    public void userChoosesFirstProduct() {
        listProductPage.getExpectedProductInfo();
        listProductPage.userChoosesFirstProduct();
    }

    public void verifyNavigationToProductDetail_page() {
        detailProductPage.getCurrentProductInfo();
        Assert.assertEquals(expectedPrdName, prdName);
        Assert.assertEquals(expectedPrdPrice, prdPrice);
    }

    public void userChoosesToAddToCompareList() {
        detailProductPage.userChoosesToAddToCompareList();
    }

    public void clickCompareCart() {
        commonPage.waitAboutSecond(6);
        commonPage.clickOnButton("compareBtn");
        comparePage.verifTitleInCompareCart();
    }

    public void verifyInformationProductInCompareCart(String productName, String price, String description, int i) {
        Product prd = comparePage.getProductInfo().get(i);
        Assert.assertEquals(productName, prd.getNamePrdInCart());
        System.out.println("done name");
        Assert.assertEquals(price, prd.getPricePrdInCart());
        System.out.println("done price");
        Assert.assertEquals(description, prd.getDescription());
        System.out.println("done description");
    }

    public void verifyDatabaseInCompareCart(String productName, String price, String description, int i) {
       if(key== "notNull") {
           Product prd = comparePage.verifyDatabaseInCompareCart().get(i);
           Assert.assertEquals(productName, prd.getNamePrdInCart());
           Assert.assertEquals(price, prd.getPricePrdInCart());
           Assert.assertEquals(description, prd.getDescription());
           System.out.println("done");
           // Assert.assertEquals(description,prd.getDescription());
       }
       else System.out.println("NOT TO CHECK DB");
    }

    public void userAddsFirstProductIntoCart() {
        comparePage.userAddsFirstProductIntoCart();
            }

    public void userRemoveFirstProductInCompareList() {
        comparePage. userRemoveFirstProductInCompareList();
    }

    public void userClicksOnProfileAndChoosesCompare() {
        commonPage.clickOnButton("profileHomePageBtn");
        commonPage.clickOnButton("comparePBtn");
        commonPage.waitAboutSecond(2);
        commonPage.verifyUrlNavigate("comparePageUrl");
        System.out.println("done verify url");
    }

    public void userMoveFirstProductToWishlist() {
        commonPage.clickOnButton("favoriteBorderBtn");
        commonPage.waitAboutSecond(2);
         commonPage.verifyMessageAlert("Success! Item Successfully Added To Wishlist.","messageRemove");
         commonPage.waitAboutSecond(5);
        comparePage.verifyIconHeartMoveToBorder();
    }

    public void userMoveFirstProductToWishlistAndPageNavigatesToLoginPage() {
        commonPage.clickOnButton("favoriteBorderBtn");
        commonPage.waitAboutSecond(2);
        commonPage.verifyUrlNavigate("loginPage");
        System.out.println("done");

    }
}
