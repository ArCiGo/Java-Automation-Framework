package Tests;

import Models.MockarooFakeModel;
import Utilities.PropertyReader;
import Utilities.Utils;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utilities.ExtentReports.ExtentTestManager.startTest;

public class SampleDataTests {

    String csvFilePath;

    @BeforeMethod
    public void initSetup() {
        String propertiesFile = "data.properties";
        PropertyReader propertyReader = new PropertyReader();
        csvFilePath = propertyReader.getProperty(propertiesFile, "CSV_FILE_PATH");
    }

    @Test(description = "Gets the data stored in a CSV file")
    public void GetCSV(Method method) throws ParseException {
        startTest(method.getName(),"Gets the data stored in a CSV file");

        String path = csvFilePath;
        Date expectedDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2021");
        var records = Utils.readDataLineByLine(path, MockarooFakeModel.class);

        for (Object obj : records) {
            MockarooFakeModel mock = (MockarooFakeModel) obj;

            if(mock.getID() == 5) {
                Assert.assertEquals(mock.getDate(), expectedDate);
            }
        }

        // Once the data is retrieved, it can be stored into variables and pass it into methods (or tests)
    }
}
