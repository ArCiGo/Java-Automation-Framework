package PageObjectModel.Pages;

import PageObjectModel.Components.CreateAccount.CreateAccountBodyComponent;
import PageObjectModel.Models.PersonModel;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class APCreateAccountPage extends BasePage {

    // Attributes
    private final CreateAccountBodyComponent createAccountBodyComponent;

    // Elements

    // Constructor
    public APCreateAccountPage(WebDriver driver) {
        super(driver);
        createAccountBodyComponent = new CreateAccountBodyComponent(driver);
    }

    // Actions
    public void fillRegisterForm(List<PersonModel> personalData) {
        createAccountBodyComponent.fillRegisterForm(personalData);
    }

    public APMyAccountPage clickOnRegisterButton() {
        return createAccountBodyComponent.clickRegisterButton();
    }
}
