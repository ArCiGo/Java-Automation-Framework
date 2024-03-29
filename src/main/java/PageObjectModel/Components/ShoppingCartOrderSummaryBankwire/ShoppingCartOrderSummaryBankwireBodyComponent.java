package PageObjectModel.Components.ShoppingCartOrderSummaryBankwire;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Pages.APShoppingCartOrderSummaryBankwirePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartOrderSummaryBankwireBodyComponent extends APComponent {

    // Attributes

    // Elements
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button btn')]")
    public WebElement confirmOrderButton;

    // Constructor
    public ShoppingCartOrderSummaryBankwireBodyComponent(WebDriver driver) {
        super(driver);

        this.driver = driver;
    }

    // Actions
    public APShoppingCartOrderSummaryBankwirePage clickOnConfirmOrderButton() {
        confirmOrderButton.click();

        return new APShoppingCartOrderSummaryBankwirePage(driver);
    }
}
