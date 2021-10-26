package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartShipping.ShoppingCartShippingBodyComponent;
import org.openqa.selenium.WebDriver;

public class APShoppingCartShippingPage extends BasePage {

    // Attributes
    private final ShoppingCartShippingBodyComponent shoppingCartShippingBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartShippingPage(WebDriver driver) {
        super(driver);
        shoppingCartShippingBodyComponent = new ShoppingCartShippingBodyComponent(driver);
    }

    // Actions
    public void checkTermsOfServiceCheckbox() {
        shoppingCartShippingBodyComponent.checkTermsOfServiceCheckbox();
    }

    public APShoppingCartPaymentMethodPage clickOnCheckoutButton() {
        return shoppingCartShippingBodyComponent.clickOnCheckoutButton();
    }
}
