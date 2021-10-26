package PageObjectModel.Components.Home;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Pages.APAuthenticationPage;
import PageObjectModel.Pages.APHomePage;
import PageObjectModel.Pages.APShoppingCartSummaryPage;
import PageObjectModel.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeHeaderComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(how = How.CLASS_NAME, using = "logout")
    public WebElement signOutButton;

    @FindBy(how = How.XPATH, using = "//img[@class='logo img-responsive']")
    public WebElement logoImg;

    @FindBy(how = How.XPATH, using = "//a[contains(@title, 'View my shopping')]")
    public WebElement cartLinkButton;

    // Constructor
    public HomeHeaderComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(logoImg)).isDisplayed();
        } catch (Exception ex) {
            Log.error(ex.toString());

            return false;
        }
    }

    public APAuthenticationPage clickOnSignInButton() {
        signInButton.click();

        return new APAuthenticationPage(driver);
    }

    public APAuthenticationPage clickOnSignOutButton() {
        signOutButton.click();

        return new APAuthenticationPage(driver);
    }

    public APHomePage clickOnImageButton() {
        logoImg.click();

        return new APHomePage(driver);
    }

    public APShoppingCartSummaryPage clickOnCartLinkButton() {
        cartLinkButton.click();

        return new APShoppingCartSummaryPage(driver);
    }
}
