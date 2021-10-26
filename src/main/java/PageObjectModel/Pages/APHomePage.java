package PageObjectModel.Pages;

import PageObjectModel.Components.Home.HomeBodyComponent;
import PageObjectModel.Components.Home.HomeHeaderComponent;
import PageObjectModel.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class APHomePage extends BasePage {

    // Attributes
    private final HomeHeaderComponent homeHeaderComponent;
    private final HomeBodyComponent homeBodyComponent;

    // Elements

    // Constructor
    public APHomePage(WebDriver driver) {
        super(driver);
        homeHeaderComponent = new HomeHeaderComponent(driver);
        homeBodyComponent = new HomeBodyComponent(driver);
    }

    // Actions
    public void goTo(String url) {
        driver.navigate().to(url);
        Log.info("URL: " + url + "opened");
    }

    public boolean isLoaded() {
        return homeHeaderComponent.isLoaded();
    }

    public APAuthenticationPage clickOnSignInButton() {
        return homeHeaderComponent.clickOnSignInButton();
    }

    public APAuthenticationPage clickOnSignOutButton() {
        return homeHeaderComponent.clickOnSignOutButton();
    }

    public APHomePage clickOnImageButton() {
        return homeHeaderComponent.clickOnImageButton();
    }

    public APShoppingCartSummaryPage clickOnCartLinkButton() {
        return homeHeaderComponent.clickOnCartLinkButton();
    }

    public void addItemsToCart(List<String> clothes) {
        homeBodyComponent.addItemsToCart(clothes);
    }
}
