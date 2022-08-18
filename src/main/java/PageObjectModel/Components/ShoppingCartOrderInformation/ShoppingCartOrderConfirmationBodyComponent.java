package PageObjectModel.Components.ShoppingCartOrderInformation;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Components.ShoppingCartAddress.ShoppingCartAddressesBodyComponent;
import PageObjectModel.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartOrderConfirmationBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.CLASS_NAME, using = "cheque-indent")
    public WebElement orderCompletedText;

    @FindBy(how = How.CLASS_NAME, using = "page-heading")
    public WebElement titleLabel;

    // Constructor
    public ShoppingCartOrderConfirmationBodyComponent(WebDriver driver) {
        super(driver);

        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(titleLabel)).isDisplayed();
        } catch (Exception ex) {
            Log.error(ex.toString());

            return false;
        }
    }

    public String getOrderConfirmationText() {
        return orderCompletedText.getText();
    }
}
