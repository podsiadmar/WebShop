package pageObjects.MyAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Base;

public class AddNewAddress extends Base {

    @FindBy(id = "Address_FirstName")
    private WebElement firstNameTextBox;
    @FindBy(id = "Address_LastName")
    private WebElement lastNameTextBox;
    @FindBy(id = "Address_Email")
    private WebElement emailTextBox;
    @FindBy(id = "Address_Company")
    private WebElement companyTextBox;
    @FindBy(id = "Address_CountryId")
    private WebElement countryId;
    @FindBy(id = "Address_StateProvinceId")
    private WebElement stateProvince;
    @FindBy(id = "Address_City")
    private WebElement cityTextBox;
    @FindBy(id = "Address_Address1")
    private WebElement address1TextBox;
    @FindBy(id = "Address_Address2")
    private WebElement address2TextBox;
    @FindBy(id = "Address_ZipPostalCode")
    private WebElement zipPostalCodeTextBox;
    @FindBy(id = "Address_PhoneNumber")
    private WebElement phoneNumberTextBox;
    @FindBy(id = "Address_FaxNumber")
    private WebElement faxNumberTextBox;
    @FindBy(css = ".save-address-button")
    private WebElement saveButton;

    public AddNewAddress() {
    }


    public AddNewAddress fillNewAddressFormula(String firstName, String lastName, String email, String company, String country,
                                               String city, String address1, String address2, String postalCode, String phoneNumber,
                                               String province, String faxNumber){
        firstNameTextBox.sendKeys(firstName);
        lastNameTextBox.sendKeys(lastName);
        emailTextBox.sendKeys(email);
        companyTextBox.sendKeys(company);

        Select drpCountry = new Select(countryId);
        drpCountry.selectByVisibleText(country);

        Select drpProvince = new Select(stateProvince);
        drpProvince.selectByVisibleText(province);

        cityTextBox.sendKeys(city);
        address1TextBox.sendKeys(address1);
        address2TextBox.sendKeys(address2);
        zipPostalCodeTextBox.sendKeys(postalCode);
        phoneNumberTextBox.sendKeys(phoneNumber);
        faxNumberTextBox.sendKeys(faxNumber);
        return this;
    }

    public void clickSaveButton(){
        saveButton.click();
    }






}
