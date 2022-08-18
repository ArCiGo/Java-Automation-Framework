package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartAddress.ShoppingCartAddressesBodyComponent;
import org.openqa.selenium.WebDriver;

public class APShoppingCartAddressesPage extends BasePage {

    // Attributes
    private final ShoppingCartAddressesBodyComponent shoppingCartAddressesBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartAddressesPage(WebDriver driver) {
        super(driver);

        shoppingCartAddressesBodyComponent = new ShoppingCartAddressesBodyComponent(driver);
    }

    // Actions
    public APShoppingCartShippingPage clickOnCheckOutButton() {
        return shoppingCartAddressesBodyComponent.clickOnCheckOutButton();
    }
}
