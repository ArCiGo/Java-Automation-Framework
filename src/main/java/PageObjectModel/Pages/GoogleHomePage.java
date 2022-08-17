package PageObjectModel.Pages;

import PageObjectModel.Components.Home.HomeBodyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends BasePage {

    // Attributes
    private HomeBodyComponent homeBodyComponent;

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.homeBodyComponent = new HomeBodyComponent(driver);
    }

    // Actions
    public void goTo(String url) {
        driver.navigate().to(url);
    }

    public GoogleResultsPage fillSearchForm(String search) {
        return this.homeBodyComponent.fillSearchForm(search);
        // return new GoogleResultsPage(driver);
    }
}
