package AutomationResources;

import Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import static Utilities.OperatingSystem.getOperatingSystem;

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
        File rootPath = new File("src/test/resources/lib-thirdparty");
        File chromeFilePath;
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        switch (getOperatingSystem()) {
            case WINDOWS:
                chromeFilePath = new File(rootPath + "/driversforwin", "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
                break;
            case MAC:
                chromeFilePath = new File(rootPath + "/driversformac", "chromedriver");
                System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
                break;
            default:
                Log.error("Unknown Operating System!");
                break;
        }

        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        File rootPath = new File("src/test/resources/lib-thirdparty");
        File firefoxFilePath;

        switch (getOperatingSystem()) {
            case WINDOWS:
                firefoxFilePath = new File(rootPath + "/driversforwin", "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
                break;
            case MAC:
                firefoxFilePath = new File(rootPath + "/driversformac", "geckodriver");
                System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
                break;
            default:
                Log.error("Unknown Operating System!");
                break;
        }

        return new FirefoxDriver();
    }
}
