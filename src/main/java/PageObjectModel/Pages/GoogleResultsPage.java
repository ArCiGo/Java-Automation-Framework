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
    private ResultsBodyComponent resultsBodyComponent;

    // Constructor
    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        this.resultsBodyComponent = new ResultsBodyComponent(driver);
    }

    // Actions

    public boolean resultsLabelIsLoaded() {
        return this.resultsBodyComponent.resultsLabelIsLoaded();
    }
}
