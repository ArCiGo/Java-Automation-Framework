package PageObjectModel.Components.Home;

import PageObjectModel.Components.GoogleComponent;
import PageObjectModel.Pages.GoogleResultsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeBodyComponent extends GoogleComponent {

    // Attributes

    // Elements
    @FindBy(how = How.XPATH, using = "//form[@action='/search']/descendant::input[@name='q']")
    public WebElement inputSearchField;

    // Constructor
    public HomeBodyComponent(WebDriver driver) {
        super(driver);
    }

    // Actions
    public GoogleResultsPage fillSearchForm(String search) {
        inputSearchField.clear();
        inputSearchField.sendKeys(search + Keys.ENTER);

        return new GoogleResultsPage(driver);
    }
}
