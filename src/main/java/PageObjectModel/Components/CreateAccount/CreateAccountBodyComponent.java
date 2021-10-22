package PageObjectModel.Components.CreateAccount;

import PageObjectModel.Components.APComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateAccountBodyComponent extends APComponent {

    // Attributes
    private final WebDriverWait wait;

    // Elements
    @FindBy(how = How.CLASS_NAME, using = "page-heading")
    public WebElement titleLabel;

    @FindBy(how = How.ID, using = "id_gender1")
    public WebElement mrRadioButton;

    @FindBy(how = How.ID, using = "id_gender2")
    public WebElement mrsRadioButton;

    @FindBy(how = How.ID, using = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(how = How.ID, using = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    public WebElement daySelect;
    public Select daySelectElement;
    public List<WebElement> dayOptions;

    @FindBy(how = How.ID, using = "months")
    public WebElement monthSelect;
    public Select monthSelectElement;
    public List<WebElement> monthOptions;

    @FindBy(how = How.ID, using = "years")
    public WebElement yearSelect;
    public Select yearSelectElement;
    public List<WebElement> yearOptions;

    @FindBy(how = How.ID, using = "firstname")
    public WebElement addressFirstNameInput;

    @FindBy(how = How.ID, using = "lastname")
    public WebElement addressLastNameInput;

    @FindBy(how = How.ID, using = "company")
    public WebElement companyInput;

    @FindBy(how = How.ID, using = "address1")
    public WebElement addressInput;

    @FindBy(how = How.ID, using = "address2")
    public WebElement addressLine2Input;

    @FindBy(how = How.ID, using = "city")
    public WebElement cityInput;

    @FindBy(how = How.ID, using = "id_state")
    public WebElement stateSelect;
    public Select stateSelectElement;
    public List<WebElement> stateOptions;

    @FindBy(how = How.ID, using = "postcode")
    public WebElement zipCodeInput;

    @FindBy(how = How.ID, using = "id_country")
    public WebElement countrySelect;
    public Select countrySelectElement;
    public List<WebElement> countryOptions;

    @FindBy(how = How.ID, using = "other")
    public WebElement additionalInformationTextarea;

    @FindBy(how = How.ID, using = "phone")
    public WebElement homePage;

    @FindBy(how = How.ID, using = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy(how = How.ID, using = "alias")
    public WebElement alias;

    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement registerButton;
}
