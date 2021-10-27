package Tests;

import AutomationResources.BrowserType;
import AutomationResources.WebDriverFactory;
import PageObjectModel.Pages.*;
import PageObjectModel.Utilities.Log;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected String baseURL;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected APAuthenticationPage apAuthenticationPage;
    protected APCreateAccountPage apCreateAccountPage;
    protected APHomePage apHomePage;
    protected APMyAccountPage apMyAccountPage;
    protected APShoppingCartAddressesPage apShoppingCartAddressesPage;
    protected APShoppingCartOrderConfirmationPage apShoppingCartOrderConfirmationPage;
    protected APShoppingCartOrderSummaryBankwirePage apShoppingCartOrderSummaryBankwirePage;
    protected APShoppingCartPaymentMethodPage apShoppingCartPaymentMethodPage;
    protected APShoppingCartShippingPage apShoppingCartShippingPage;
    protected APShoppingCartSummaryPage apShoppingCartSummaryPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Log.info("I am in Before Method! Test is starting!");

        driver = WebDriverFactory.getDriver(BrowserType.Chrome);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        initSetup();
    }

    private void initSetup() {
        String propertiesFile = "data.properties";
        PropertyReader propertyReader = new PropertyReader();
        apAuthenticationPage = new APAuthenticationPage(driver);
        apCreateAccountPage = new APCreateAccountPage(driver);
        apHomePage = new APHomePage(driver);
        apMyAccountPage = new APMyAccountPage(driver);
        apShoppingCartAddressesPage = new APShoppingCartAddressesPage(driver);
        apShoppingCartOrderConfirmationPage = new APShoppingCartOrderConfirmationPage(driver);
        apShoppingCartOrderSummaryBankwirePage = new APShoppingCartOrderSummaryBankwirePage(driver);
        apShoppingCartPaymentMethodPage = new APShoppingCartPaymentMethodPage(driver);
        apShoppingCartShippingPage = new APShoppingCartShippingPage(driver);
        apShoppingCartSummaryPage = new APShoppingCartSummaryPage(driver);

        baseURL = propertyReader.getProperty(propertiesFile, "AUTOMATION_PRACTICE_URL");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Log.info("I am in After Method! Test is ending!");

        driver.close();
        driver.quit();
    }
}
