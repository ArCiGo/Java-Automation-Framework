package Tests;

import Data.Mocks;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class AutomationPracticesTests extends BaseTest {

    // Properties
    private String emailAddress, password;

    // Tests
    @Test(description = "It creates a new user in the store",
            priority = 1)
    public void CreateNewUserWithValidData(Method method) {
        startTest(method.getName(), "It creates a new user in the store");

        emailAddress = Mocks.personalData().get(0).getEmail();
        password = Mocks.personalData().get(0).getPassword();

        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillCreateAccountForm(emailAddress);
        apAuthenticationPage.clickOnCreateAccountButton();

        apCreateAccountPage.fillRegisterForm(Mocks.personalData());
        apCreateAccountPage.clickOnRegisterButton();

        Assert.assertTrue(apMyAccountPage.isLoaded());
    }

    @Test(description = "It logins successfully in the store with a valid user",
            priority = 2)
    public void LoginWithAValidUser(Method method) {
        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillSignInForm(emailAddress, password);
        apAuthenticationPage.clickOnSignInButton();

        Assert.assertTrue(apMyAccountPage.isLoaded());
    }

    @Test(description = "It throws an error when the user attempts to login with an invalid user",
            priority = 3)
    public void LoginWithAnInvalidUser(Method method) {
        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillSignInForm(Mocks.invalidPersonalData().getEmail(), Mocks.invalidPersonalData().getPassword());
        apAuthenticationPage.clickOnSignInButton();

        Assert.assertEquals("Authentication failed.", apAuthenticationPage.IsErrorBannerDisplayed());
    }


}
