package PageObjectModel.Pages;

import PageObjectModel.Components.Results.ResultsBodyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleResultsPage extends BasePage {

    // Attributes
    private WebDriverWait wait;
    private ResultsBodyComponent resultsBodyComponent;

    // Elements
    @FindBy(how = How.XPATH, using = "//img[@alt='Google']")
    public WebElement googleLogoImg;

    // Constructor
    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        resultsBodyComponent = new ResultsBodyComponent(driver);
    }

    // Actions
    /**
     * This is a generic validation
     */
    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(googleLogoImg)).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean ResultsLabelIsLoaded() {
        return resultsBodyComponent.resultsLabelIsLoaded();
    }
}
