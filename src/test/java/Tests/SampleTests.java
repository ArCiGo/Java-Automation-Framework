package Tests;

import PageObjectModel.Pages.GoogleHomePage;
import PageObjectModel.Pages.GoogleResultsPage;
import Utilities.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class SampleTests extends BaseTest {

    private String baseURL, itemToSearch;
    GoogleHomePage googleHomePage;
    GoogleResultsPage googleResultsPage;

    @BeforeMethod
    public void initSetup() {
        String propertiesFile = "data.properties";
        PropertyReader propertyReader = new PropertyReader();
        googleHomePage = new GoogleHomePage(driver);
        googleResultsPage = new GoogleResultsPage(driver);

        baseURL = propertyReader.getProperty(propertiesFile, "GOOGLE_URL");
        itemToSearch = propertyReader.getProperty(propertiesFile, "ITEM_TO_SEARCH");
    }

    @Test(description = "This is a sample test.")
    public void Test1(Method method) {
        startTest(method.getName(), "This is a sample test.");

        driver.navigate().to(baseURL);
        driver.findElement(By.xpath("//form[@action='/search']/descendant::input[@name='q']")).sendKeys(itemToSearch + Keys.ENTER);

        var resultsText = driver.findElement(By.xpath("//div[@id='result-stats']"));

        Assert.assertTrue(resultsText.isDisplayed());
    }

    @Test(description = "This is a sample test using POM and components.")
    public void Test2(Method method) {
        startTest(method.getName(), "This is a sample test using POM and components.");

        googleHomePage.goTo(baseURL);
        Assert.assertTrue(googleHomePage.isLoaded());

        googleHomePage.fillSearchForm(itemToSearch);

        Assert.assertTrue(googleResultsPage.isLoaded());
        Assert.assertTrue(googleResultsPage.resultsLabelIsLoaded());
    }

    @Test(description = "This sample test should fail for the screenshot.")
    public void Test3(Method method) {
        startTest(method.getName(), "This sample test should fail for the screenshot.");
        driver.navigate().to(baseURL);

        driver.findElement(By.id("sample"));
    }
}
