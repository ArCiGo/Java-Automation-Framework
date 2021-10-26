package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartPaymentMethod.ShoppingCartPaymentMethodBodyComponent;
import org.openqa.selenium.WebDriver;

public class APShoppingCartPaymentMethodPage extends BasePage {

    // Attributes
    private final ShoppingCartPaymentMethodBodyComponent shoppingCartPaymentMethodBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartPaymentMethodPage(WebDriver driver) {
        super(driver);
        shoppingCartPaymentMethodBodyComponent = new ShoppingCartPaymentMethodBodyComponent(driver);
    }

    // Actions
    public APShoppingCartOrderConfirmationPage clickOnBankwireButton() {
        return shoppingCartPaymentMethodBodyComponent.clickOnBankwireButton();
    }
}
