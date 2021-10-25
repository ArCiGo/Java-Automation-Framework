package PageObjectModel.Components.ShoppingCartOrderSummaryBankwire;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartOrderSummaryBankwireBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button btn')]")
    public WebElement confirmOrderButton;

    // Constructor
    public ShoppingCartOrderSummaryBankwireBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public APShoppingCartOrderSummaryBankwirePage clickOnConfirmOrderButton() {
        confirmOrderButton.click();

        return new APShoppingCartOrderSummaryBankwirePage(driver);
    }
}
