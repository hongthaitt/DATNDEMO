package starter.steps.serenity;

import starter.pages.Homepage;
import starter.pages.ListProductPage;

import java.sql.SQLException;

public class SearchProductEndUserSteps {
    Homepage homePage;
    ListProductPage listProductPage;

    public void verifyListProduct(String productName) throws SQLException {
        homePage.searchProduct(productName);
        listProductPage.verifyListProduct(productName);
    }

    public void verifyNoResultProduct(String productName) throws SQLException {
        homePage.searchProduct(productName);
        listProductPage.verifyNoResultProduct(productName);
    }

    public void userClickUploadFile() {
        homePage.userClickUploadFile();
    }

}
