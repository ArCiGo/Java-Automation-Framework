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
    private WebDriverWait wait;
    private HomeBodyComponent homeBodyComponent;

    // Elements
    @FindBy(how = How.XPATH, using = "//img[@alt='Google']")
    public WebElement googleLogoImg;

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        this.homeBodyComponent = new HomeBodyComponent(driver);
    }

    // Actions
    public void goTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * This is a generic validation
     */
    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(this.googleLogoImg)).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public GoogleResultsPage fillSearchForm(String search) {
        this.homeBodyComponent.fillSearchForm(search);

        return new GoogleResultsPage(driver);
    }
}
