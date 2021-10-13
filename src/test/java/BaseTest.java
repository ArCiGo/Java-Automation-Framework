import AutomationResources.BrowserType;
import AutomationResources.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        // Log.info("I am in Before Method! Test is starting!");

        driver = WebDriverFactory.getDriver(BrowserType.Chrome);
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        // Log.info("I am in After Method! Test is ending!");

        driver.quit();
        driver.close();
    }
}
