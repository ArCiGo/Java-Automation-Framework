package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartSummary.ShoppingCartSummaryBodyComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class APShoppingCartSummaryPage extends BasePage {

    // Attributes
    private final ShoppingCartSummaryBodyComponent shoppingCartSummaryBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        shoppingCartSummaryBodyComponent = new ShoppingCartSummaryBodyComponent(driver);
    }

    // Actions
    public boolean isOnShoppingCart(List<String> clothes) {
        return shoppingCartSummaryBodyComponent.isOnShoppingCart(clothes);
    }

    public APShoppingCartAddressesPage clickOnCheckoutButton() {
        return shoppingCartSummaryBodyComponent.clickOnCheckoutButton();
    }
}
