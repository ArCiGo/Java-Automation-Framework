package PageObjectModel.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleComponent {

    protected WebDriver driver;

    public GoogleComponent(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
