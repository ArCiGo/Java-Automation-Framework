package PageObjectModel.Components.CreateAccount;

import PageObjectModel.Components.APComponent;
import PageObjectModel.Models.PersonModel;
import PageObjectModel.Models.Title;
import PageObjectModel.Pages.APMyAccountPage;
import PageObjectModel.Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
    public WebElement homePhone;

    @FindBy(how = How.ID, using = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy(how = How.ID, using = "alias")
    public WebElement alias;

    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement registerButton;

    // Constructor
    public CreateAccountBodyComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    // Actions
    public boolean titleRadioButtonsIsLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(mrRadioButton)).isDisplayed();
        } catch (Exception ex) {
            Log.error(ex.toString());
            return false;
        }
    }

    public void fillRegisterForm(List<PersonModel> personalData, String emailAddress, String password) {
        selectTitle(personalData.get(0).getTitle());

        firstNameInput.clear();
        firstNameInput.sendKeys(personalData.get(0).getFirstName());

        lastNameInput.clear();
        lastNameInput.sendKeys(personalData.get(0).getLastName());

        passwordInput.clear();
        passwordInput.sendKeys(password);

        setDay(personalData.get(0).getDay());
        setMonth(personalData.get(0).getMonth());
        setYear(personalData.get(0).getYear());

        addressFirstNameInput.clear();
        addressFirstNameInput.sendKeys(personalData.get(0).getFirstNameAddress());

        addressLastNameInput.clear();
        addressLastNameInput.sendKeys(personalData.get(0).getLastNameAddress());

        companyInput.clear();
        companyInput.sendKeys(personalData.get(0).getCompany());

        addressInput.clear();
        addressInput.sendKeys(personalData.get(0).getAddress());

        addressLine2Input.clear();
        addressLine2Input.sendKeys(personalData.get(0).getAddressLine2());

        cityInput.clear();
        cityInput.sendKeys(personalData.get(0).getCity());

        setState(personalData.get(0).getState());

        zipCodeInput.clear();
        zipCodeInput.sendKeys(personalData.get(0).getZipCode());

        setCountry(personalData.get(0).getCountry());

        additionalInformationTextarea.clear();
        additionalInformationTextarea.sendKeys(personalData.get(0).getAdditionalInformation());

        homePhone.clear();
        homePhone.sendKeys(personalData.get(0).getHomePhone());

        mobilePhone.clear();
        mobilePhone.sendKeys(personalData.get(0).getMobilePhone());

        alias.clear();
        alias.sendKeys(personalData.get(0).getAddressAlias());
    }

    private void selectTitle(Title title) {
        titleRadioButtonsIsLoaded();

        switch (title)
        {
            case Mr:
                mrRadioButton.click();
                break;
            case Mrs:
                mrsRadioButton.click();
                break;
            default:
                IllegalArgumentException ex = new IllegalArgumentException("No such option exists!");
                Log.error(ex.toString());

                throw ex;
        }
    }

    private void setDay(String day) {
        daySelectElement = new Select(daySelect);
        dayOptions = daySelectElement.getOptions();

        for (WebElement item : dayOptions) {
            if(item.getAttribute("value").contains(day)) {
                daySelectElement.selectByValue(day);
            }
        }
    }

    private void setMonth(String month) {
        monthSelectElement = new Select(monthSelect);
        monthOptions = monthSelectElement.getOptions();

        for (WebElement item : monthOptions) {
            if(item.getText().trim().contains(month)) {
                monthSelectElement.selectByVisibleText(item.getText());
            }
        }
    }

    private void setYear(String year) {
        yearSelectElement = new Select(yearSelect);
        yearOptions = yearSelectElement.getOptions();

        for (WebElement item : yearOptions) {
            if(item.getAttribute("value").contains(year)) {
                yearSelectElement.selectByValue(year);
            }
        }
    }

    private void setState(String state) {
        stateSelectElement = new Select(stateSelect);
        stateOptions = stateSelectElement.getOptions();

        for (WebElement item : stateOptions) {
            if(item.getText().contains(state)) {
                stateSelectElement.selectByVisibleText(state);
            }
        }
    }

    private void setCountry(String country) {
        countrySelectElement = new Select(countrySelect);
        countryOptions = countrySelectElement.getOptions();

        for (WebElement item : countryOptions) {
            if(item.getText().contains(country)) {
                countrySelectElement.selectByVisibleText(country);
            }
        }
    }

    public APMyAccountPage clickRegisterButton() {
        wait.until(ExpectedConditions.visibilityOf(registerButton)).click();

        return new APMyAccountPage(driver);
    }
}
