package pf;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPF extends LoadableComponent<SearchPF> {
    private WebDriver driver;
    private WebDriverWait wait;

    Context context;

    private static final String HOMEURL = "http://automationpractice.com/index.php";

    //search

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchField;

    @FindBy(how = How.CLASS_NAME, using = "button-search")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = ".right-block [title='Printed Chiffon Dress']")
    private WebElement seachedPoduct;


    @Override
    public void load() {
        driver.get(HOMEURL);
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertEquals("Page is not loaded",
                HOMEURL,
                driver.getCurrentUrl());
    }

    public SearchPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void searchForAProduct(String product) {
        searchField.sendKeys(product);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void verifyIsSearchedProductDisplayed() {
        Assert.assertEquals("Searched product is NOT displayed",
                seachedPoduct, driver.findElement(By.cssSelector(".right-block [title='Printed Chiffon Dress']")));
    }

    public void quit() {
        driver.quit();
    }


}