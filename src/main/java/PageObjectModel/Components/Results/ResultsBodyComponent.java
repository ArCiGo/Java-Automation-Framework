package PageObjectModel.Components.Results;

import PageObjectModel.Components.GoogleComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsBodyComponent extends GoogleComponent {

    // Attributes
    private WebDriverWait wait;

    // Elements
    @FindBy(how = How.XPATH, using = "//div[@id='result-stats']")
    public WebElement resultsLabel;

    // Constructor
    public ResultsBodyComponent(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }

    // Actions
    public boolean resultsLabelIsLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(resultsLabel)).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
