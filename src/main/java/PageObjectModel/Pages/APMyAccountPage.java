package PageObjectModel.Pages;

import PageObjectModel.Components.MyAccount.MyAccountBodyComponent;
import org.openqa.selenium.WebDriver;

public class APMyAccountPage extends BasePage {

    // Attributes
    private final MyAccountBodyComponent myAccountBodyComponent;

    // Elements

    // Constructor
    public APMyAccountPage(WebDriver driver) {
        super(driver);
        myAccountBodyComponent = new MyAccountBodyComponent(driver);
    }

    // Actions
    public boolean isLoaded() {
        return myAccountBodyComponent.isLoaded();
    }
}
