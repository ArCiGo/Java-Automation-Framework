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

    public String getOrderConfirmationText() {
        return shoppingCartOrderConfirmationBodyComponent.getOrderConfirmationText();
    }
}
