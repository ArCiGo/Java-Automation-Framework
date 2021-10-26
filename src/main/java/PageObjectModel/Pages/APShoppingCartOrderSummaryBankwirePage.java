package PageObjectModel.Pages;

import PageObjectModel.Components.ShoppingCartOrderSummaryBankwire.ShoppingCartOrderSummaryBankwireBodyComponent;
import org.openqa.selenium.WebDriver;

public class APShoppingCartOrderSummaryBankwirePage extends BasePage {

    // Attributes
    private final ShoppingCartOrderSummaryBankwireBodyComponent shoppingCartOrderSummaryBankwireBodyComponent;

    // Elements

    // Constructor
    public APShoppingCartOrderSummaryBankwirePage(WebDriver driver) {
        super(driver);
        shoppingCartOrderSummaryBankwireBodyComponent = new ShoppingCartOrderSummaryBankwireBodyComponent(driver);
    }

    // Actions
    public APShoppingCartOrderSummaryBankwirePage clickOnConfirmOrderButton() {
        return shoppingCartOrderSummaryBankwireBodyComponent.clickOnConfirmOrderButton();
    }
}
