package Tests;

import Data.Mocks;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class AutomationPracticesTests extends BaseTest {

    // Properties
    private String emailAddress = Mocks.validCredentials().getEmail(),
            password = Mocks.validCredentials().getPassword();

    // Tests
    @Test(description = "It creates a new user in the store",
            priority = 1)
    public void CreateNewUserWithValidData(Method method) {
        startTest(method.getName(), "It creates a new user in the store");

        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillCreateAccountForm(emailAddress);
        apAuthenticationPage.clickOnCreateAccountButton();

        apCreateAccountPage.fillRegisterForm(Mocks.personalData(), password);
        apCreateAccountPage.clickOnRegisterButton();

        Assert.assertTrue(apMyAccountPage.isLoaded());
    }

    @Test(description = "It logins successfully in the store with a valid user",
            priority = 2)
    public void LoginWithAValidUser(Method method) {
        startTest(method.getName(), "It logins successfully in the store with a valid user");

        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillSignInForm(emailAddress, password);
        apAuthenticationPage.clickOnSignInButton();

        Assert.assertTrue(apMyAccountPage.isLoaded());
    }

    @Test(description = "It throws an error when the user attempts to login with an invalid user",
            priority = 3)
    public void LoginWithAnInvalidUser(Method method) {
        startTest(method.getName(), "It throws an error when the user attempts to login with an invalid user");

        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillSignInForm(Mocks.invalidPersonalData().getEmail(), Mocks.invalidPersonalData().getPassword());
        apAuthenticationPage.clickOnSignInButton();

        Assert.assertEquals("Authentication failed.", apAuthenticationPage.IsErrorBannerDisplayed());
    }

    @Test(description = "It logouts successfully",
            priority = 4)
    public void LogoutWithAValidUser(Method method) {
        startTest(method.getName(), "It logouts successfully");

        apHomePage.goTo(baseURL);
        apHomePage.clickOnSignInButton();

        apAuthenticationPage.fillSignInForm(emailAddress, password);
        apAuthenticationPage.clickOnSignInButton();

        Assert.assertTrue(apMyAccountPage.isLoaded());
        apHomePage.clickOnSignOutButton();
    }

    @Test(description = "It adds multiple items to the shopping cart",
            priority = 5)
    public void AddingMultipleItemsToCart(Method method) {
        startTest(method.getName(), "It adds multiple items to the shopping cart");

        List<String> clothes = new ArrayList<String>() {{
            add("Faded Short Sleeve T-shirts");
            add("Printed Chiffon Dress");
        }};

        apHomePage.goTo(baseURL);
        apHomePage.addItemsToCart(clothes);
        apHomePage.clickOnCartLinkButton();

        Assert.assertTrue(apShoppingCartSummaryPage.isOnShoppingCart(clothes));
        apShoppingCartSummaryPage.clickOnCheckoutButton();

        apAuthenticationPage.fillSignInForm(emailAddress, password);
        apAuthenticationPage.clickOnSignInButton();

        apShoppingCartAddressesPage.clickOnCheckOutButton();

        apShoppingCartShippingPage.checkTermsOfServiceCheckbox();
        apShoppingCartShippingPage.clickOnCheckoutButton();

        apShoppingCartPaymentMethodPage.clickOnBankwireButton();

        apShoppingCartOrderSummaryBankwirePage.clickOnConfirmOrderButton();

        Assert.assertTrue(apShoppingCartOrderConfirmationPage.isLoaded());
        Assert.assertEquals(apShoppingCartOrderConfirmationPage.getOrderConfirmationText(), "Your order on My Store is complete.");
    }
}
