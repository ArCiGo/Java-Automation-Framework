package PageObjectModel.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class APComponent {

    protected WebDriver driver;

    public APComponent(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
