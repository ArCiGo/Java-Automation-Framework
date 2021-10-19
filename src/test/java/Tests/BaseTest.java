package Tests;

import AutomationResources.BrowserType;
import AutomationResources.WebDriverFactory;
import PageObjectModel.Pages.GoogleHomePage;
import PageObjectModel.Pages.GoogleResultsPage;
import Utilities.Log;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected String baseURL, itemToSearch;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected GoogleHomePage googleHomePage;
    protected GoogleResultsPage googleResultsPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        Log.info("I am in Before Method! Test is starting!");

        driver = WebDriverFactory.getDriver(BrowserType.Chrome);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void initSetup() {
        String propertiesFile = "data.properties";
        PropertyReader propertyReader = new PropertyReader();
        googleHomePage = new GoogleHomePage(driver);
        googleResultsPage = new GoogleResultsPage(driver);

        baseURL = propertyReader.getProperty(propertiesFile, "GOOGLE_URL");
        itemToSearch = propertyReader.getProperty(propertiesFile, "ITEM_TO_SEARCH");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        Log.info("I am in After Method! Test is ending!");

        driver.close();
        driver.quit();
    }
}
