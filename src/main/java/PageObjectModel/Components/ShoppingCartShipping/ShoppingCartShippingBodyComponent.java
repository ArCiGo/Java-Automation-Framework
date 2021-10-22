package PageObjectModel.Components.ShoppingCartShipping;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartShippingBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.ID, using = "cgv")
    public WebElement termsOfServiceCheckbox;

    @FindBy(how = How.NAME, using = "processCarrier")
    public WebElement checkoutButton;

    // Constructor
    public ShoppingCartShippingBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public void checkTermsOfServiceCheckbox() {
        termsOfServiceCheckbox.click();
    }

    public APShoppingCartPaymentMethodPage clickOnCheckoutButton() {
        checkoutButton.click();

        return new APShoppingCartPaymentMethodPage(driver);
    }
}
