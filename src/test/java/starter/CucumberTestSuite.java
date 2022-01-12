package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import starter.dataService.TestDataService;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/search/SearchProduct.feature",
        tags="@SearchProduct"

)

public class CucumberTestSuite {
    @BeforeClass
    public static void initConfiguration() {
        TestDataService.setProperties("src\\test\\resources\\data_test\\data.properties");
        String a= TestDataService.properties.getProperty("loginPage");
        System.out.println("thu cai na: "+a );
    }
}
