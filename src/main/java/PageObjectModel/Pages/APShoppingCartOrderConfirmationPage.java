package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartOrderInformation.ShoppingCartOrderConfirmationBodyComponent;
import org.openqa.selenium.WebDriver;

public class APShoppingCartOrderConfirmationPage extends BasePage {

    // Attributes
    private final ShoppingCartOrderConfirmationBodyComponent shoppingCartOrderConfirmationBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartOrderConfirmationPage(WebDriver driver) {
        super(driver);
        shoppingCartOrderConfirmationBodyComponent = new ShoppingCartOrderConfirmationBodyComponent(driver);
    }

    // Actions
    public boolean isLoaded() {
        return shoppingCartOrderConfirmationBodyComponent.isLoaded();
    }

    public String getOrderConfirmationText() {
        return shoppingCartOrderConfirmationBodyComponent.getOrderConfirmationText();
    }
}
