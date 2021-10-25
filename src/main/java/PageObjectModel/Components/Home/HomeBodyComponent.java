package PageObjectModel.Components.Home;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;
    private final HomeHeaderComponent homeHeaderComponent;

    // Elements
    @FindBy(how = How.XPATH, using = "//ul[@id='homefeatured']/li/descendant::img[@class='replace-2x img-responsive']")
    public List<WebElement> clotheImages;

    @FindBy(how = How.XPATH, using = "//ul[@id='homefeatured']/li/descendant::div[@class='button-container']/a[@title='Add to cart']")
    public List<WebElement> cartButtons;

    @FindBy(how = How.XPATH, using = "//div[@class='button-container']/span")
    public WebElement continueShoppingButton;

    @FindBy(how = How.ID, using = "layer_cart")
    public WebElement modalConfirmation;

    // Constructor
    public HomeBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        homeHeaderComponent = new HomeHeaderComponent(driver);
    }

    // Actions
    public void addItemsToCart(List<String> clothes) {
        for(int i = 0; i < clothes.size(); i ++) {
            for(int j = 0; j < clotheImages.size(); j++) {
                Actions action = new Actions(driver);
                action.moveToElement(clotheImages.get(j)).build().perform();

                if(cartButtons.get(j).isDisplayed() && (clothes.get(i).equals(clotheImages.get(j).getAttribute("alt")))) {
                    cartButtons.get(j).click();
                    wait.until(ExpectedConditions.visibilityOf(modalConfirmation));
                    continueShoppingButton.click();
                    homeHeaderComponent.isLoaded();
                }
            }
        }
    }
}
