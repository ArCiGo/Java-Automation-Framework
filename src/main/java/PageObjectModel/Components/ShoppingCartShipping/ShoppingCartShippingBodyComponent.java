package PageObjectModel.Components.ShoppingCartShipping;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Pages.APShoppingCartPaymentMethodPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartShippingBodyComponent extends APComponent {

    // Attributes

    // Elements
    @FindBy(how = How.ID, using = "cgv")
    public WebElement termsOfServiceCheckbox;

    @FindBy(how = How.NAME, using = "processCarrier")
    public WebElement checkoutButton;

    // Constructor
    public ShoppingCartShippingBodyComponent(WebDriver driver) {
        super(driver);

        this.driver = driver;
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
