package Tests;

import Models.CsvBean;
import Models.MockarooFakeModel;
import Utilities.Utils;
import com.opencsv.bean.CsvToBean;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Test(description = "Gets the data stored in a CSV file")
    public void Test4(Method method) throws URISyntaxException {
        startTest(method.getName(),"Gets the data stored in a CSV file");

        String path = "src/test/java/Data/SampleData_2.csv";
        var records = Utils.readDataLineByLine(path, MockarooFakeModel.class);

        for (Object obj : records) {
            MockarooFakeModel mock = (MockarooFakeModel) obj;
            System.out.println(mock.getDate());
        }
    }
}
