package PageObjectModel.Components.ShoppingCartAddress;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartAddressesBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.NAME, using = "processAddress")
    public WebElement checkoutButton;

    // Constructor
    public ShoppingCartAddressesBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public APShoppingCartShippingPage clickOnCheckOutButton() {
        checkoutButton.click();

        return new APShoppingCartShippingPage(driver);
    }
}
