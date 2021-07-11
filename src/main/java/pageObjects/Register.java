package pageObjects;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Register extends Base{

    @FindBy(id = "gender-male")
    private WebElement maleRadioButton;
    @FindBy(id = "gender-female")
    private WebElement femaleRadioButton;
    @FindBy(id = "FirstName")
    private WebElement firstNameTextBox;
    @FindBy(id = "LastName")
    private WebElement lastNameTextBox;
    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextBox;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(className = "result")
    private WebElement registerNotification;
    @FindBy(className = "account")
    public WebElement accountLink;

    public Register registerNewUser(String gender, String firsName, String lastName, String eMail, String password, String confirmPassword){
        switch (gender){
            case "M":
                maleRadioButton.click();
                break;
            case "F":
                femaleRadioButton.click();
                break;
            default:
                throw new InvalidArgumentException("Gender field value is invalid.");
        }

        firstNameTextBox.sendKeys(firsName);
        lastNameTextBox.sendKeys(lastName);
        emailTextBox.sendKeys(eMail);
        passwordTextBox.sendKeys(password);
        confirmPasswordTextBox.sendKeys(confirmPassword);
        registerButton.click();
        return this;
    }

    public HomePage verifyRegistrationCompletion(String newEmail){
        Assert.assertEquals(registerNotification.getText().trim(), "Your registration completed");
        Assert.assertEquals(accountLink.getText().trim(), newEmail);
        return new HomePage();
    }
}
