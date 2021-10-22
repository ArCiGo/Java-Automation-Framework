package PageObjectModel.Components.ShoppingCartSummary;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartSummaryBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.CSS, using = "td p.product-name a")
    public List<WebElement> productNameLabel;

    @FindBy(how = How.CSS, using = "p[class='cart_navigation clearfix'] a[title^='Proceed']")
    public WebElement checkoutButton;

    // Constructor
    public ShoppingCartSummaryBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public boolean isOnShoppingCart(List<String> clothes) {
        for (int i = 0; i < clothes.size(); i++) {
            for (int j = 0; j < productNameLabel.size(); j++) {
                if(clothes.get(i).equals(productNameLabel.get(j).getText())) {
                    return true;
                }
            }
        }

        return false;
    }

    public APShoppingCartAddressPage clickOnCheckoutButton() {
        checkoutButton.click();

        return new APShoppingCartAddressPage(driver);
    }
}
