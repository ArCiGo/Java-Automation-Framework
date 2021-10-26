package Tests;

import Data.Mocks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class AutomationPracticesTests extends BaseTest {

    // Properties
    private String emailAddress, password;

    // Tests
    @Test(description = "It creates a new user in the store")
    public void CreateNewUserWithValidData(Method method) {
        startTest(method.getName(), "It creates a new user in the store");

        emailAddress = Mocks.personalData().get(0).getEmail();
        password = Mocks.personalData().get(0).getPassword();
    }
}
