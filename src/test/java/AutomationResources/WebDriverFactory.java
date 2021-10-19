package AutomationResources;

import Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static Utilities.OperatingSystem.getOperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case Chrome:
                return getChromeDriver();
            case Firefox:
                return getFirefoxDriver();
            default:
                Log.error("No such browser exists!");
                return  null;
        }
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();

        return new FirefoxDriver();
    }
}
