package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pf.BaseTest;
import pf.SearchPF;
import pf.UserLoginPF;

public class SearchForAProductPositiveTestStep {
    private SearchPF searchPF;
    private String product = "Printed Chiffon Dress";

    WebDriver driver = BaseTest.getDriver();


    public SearchForAProductPositiveTestStep(BaseTest baseTest) {
        searchPF = new SearchPF(driver);
    }

    @Given("Customer is on Home page")
    public void customerIsOnHomePage() {
        searchPF.load();
        searchPF.isLoaded();
    }

    @And("enters a Product name in the Search field")
    public void entersAProductNameInTheSearchField() {
        searchPF.searchForAProduct(product);

    }

    @When("clicks Search button")
    public void clickSearchButton() {
        searchPF.clickSearchButton();
    }

    @Then("searched Product is successfully displayed")
    public void userIsSuccessfullyLoggedIn() {
        searchPF.verifyIsSearchedProductDisplayed();
        searchPF.quit();
    }
}
