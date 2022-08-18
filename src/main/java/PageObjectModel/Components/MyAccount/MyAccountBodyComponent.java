package PageObjectModel.Components.MyAccount;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading'][contains(text(), 'My acc')]")
    public WebElement titleLabel;

    // Constructor
    public MyAccountBodyComponent(WebDriver driver) {
        super(driver);

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    // Actions
    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(titleLabel)).isDisplayed();
        } catch (Exception ex) {
            Log.error(ex.toString());

            return false;
        }
    }
}
