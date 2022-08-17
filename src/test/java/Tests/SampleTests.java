package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class SampleTests extends BaseTest {

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
        googleHomePage.fillSearchForm(itemToSearch);

        Assert.assertTrue(googleResultsPage.resultsLabelIsLoaded());
    }

    @Test(description = "This sample test should fail for the screenshot.")
    public void Test3(Method method) {
        startTest(method.getName(), "This sample test should fail for the screenshot.");
        driver.navigate().to(baseURL);

        driver.findElement(By.id("sample"));
    }
}
