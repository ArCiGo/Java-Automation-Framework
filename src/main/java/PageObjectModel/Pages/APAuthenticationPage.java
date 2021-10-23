package PageObjectModel.Pages;

import PageObjectModel.Components.Authentication.AuthenticationBodyComponent;
import org.openqa.selenium.WebDriver;

public class APAuthenticationPage extends BasePage {

    // Attributes
    private final AuthenticationBodyComponent authenticationBodyComponent;

    // Elements

    // Constructor
    public APAuthenticationPage(WebDriver driver) {
        super(driver);
        authenticationBodyComponent = new AuthenticationBodyComponent(driver);
    }

    // Actions
    public void fillCreateAccountForm(String email) {
        authenticationBodyComponent.fillCreateAccountForm(email);
    }

    public APCreateAccountPage clickOnCreateAccountButton() {
        return authenticationBodyComponent.clickOnCreateAccountButton();
    }

    public void fillSignInForm(String email, String password) {
        authenticationBodyComponent.fillSignInForm(email, password);
    }

    public APMyAccountPage clickOnSignInButton() {
        return authenticationBodyComponent.clickOnSignInButton();
    }

    public String IsErrorBannerDisplayed() {
        return authenticationBodyComponent.isErrorBannerDisplayed();
    }
}
