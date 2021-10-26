package PageObjectModel.Components.ShoppingCartPaymentMethod;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Pages.APShoppingCartOrderConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPaymentMethodBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'bankwire')]")
    public WebElement bankwireButton;

    // Constructor
    public ShoppingCartPaymentMethodBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public APShoppingCartOrderConfirmationPage clickOnBankwireButton() {
        bankwireButton.click();

        return new APShoppingCartOrderConfirmationPage(driver);
    }
}
