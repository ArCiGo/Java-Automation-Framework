package PageObjectModel.Components.Authentication;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.ID, using = "email_create")
    public WebElement emailAddressCreateInput;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(), 'Already')]/following-sibling::div/div[@class='form-group']/input[@id='email']")
    public WebElement emailAddressAlreadyInput;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(), 'Already')]/following-sibling::div/div[@class='form-group'][2]/span/input[@id='passwd']")
    public WebElement passwordAlreadyInput;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//h1/following-sibling::div[@class='alert alert-danger']/descendant::li")
    public WebElement errorBanner;

    // Constructor
    public AuthenticationBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public void fillCreateAccountForm(String email) {
        emailAddressCreateInput.clear();
        emailAddressCreateInput.sendKeys(email);
    }

    public APCreateAccountPage clickOnCreateAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));

        return new APCreateAccountPage(driver);
    }

    public void fillSignInForm(String email, String password) {
        emailAddressAlreadyInput.clear();
        emailAddressAlreadyInput.sendKeys(email);

        passwordAlreadyInput.clear();
        passwordAlreadyInput.sendKeys(password);
    }

    public APMyAccountPage clickOnSignInButton() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));

        return new APMyAccountPage(driver);
    }

    public String isErrorBannerDisplayed() {
        if (wait.until(ExpectedConditions.visibilityOf(errorBanner)).isDisplayed()) {
           return errorBanner.getText();
        }

        return null;
    }
}
