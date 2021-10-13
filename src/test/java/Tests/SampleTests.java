package Tests;

import PageObjectModel.Pages.GoogleHomePage;
import PageObjectModel.Pages.GoogleResultsPage;
import Utilities.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTests extends BaseTest {

    private String baseURL, itemToSearch;
    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    GoogleResultsPage googleResultsPage = new GoogleResultsPage(driver);

    @BeforeMethod
    public void initSetup() {
        String propertiesFile = "data.properties";
        PropertyReader propertyReader = new PropertyReader();

        baseURL = propertyReader.getProperty(propertiesFile, "GOOGLE_URL");
        itemToSearch = propertyReader.getProperty(propertiesFile, "ITEM_TO_SEARCH");
    }

    @Test(description = "This is a sample test")
    public void Test1() {
        driver.navigate().to(baseURL);
        driver.findElement(By.xpath("//form[@action='/search']/descendant::input[@name='q']")).sendKeys(itemToSearch + Keys.ENTER);

        var resultsText = driver.findElement(By.xpath("//div[@id='result-stats']"));

        Assert.assertTrue(resultsText.isDisplayed());
    }

    @Test(description = "This is a sample test using POM and components")
    public void Test2() {
        googleHomePage.goTo(baseURL);
        Assert.assertTrue(googleHomePage.isLoaded());

        googleHomePage.fillSearchForm(itemToSearch);

        Assert.assertTrue(googleResultsPage.isLoaded());
        Assert.assertTrue(googleResultsPage.resultsLabelIsLoaded());
    }
}
