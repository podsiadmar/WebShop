package pageObjects;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    //errors
    @FindBy(css = "[data-valmsg-for=FirstName] span")
    private WebElement firstNameError;
    @FindBy(css = "[data-valmsg-for=LastName] span")
    private WebElement lastNameError;
    @FindBy(css = "[data-valmsg-for=Email] span")
    private WebElement emailError;
    @FindBy(css = "[data-valmsg-for=Password] span")
    private WebElement passwordError;
    @FindBy(css = "[data-valmsg-for=ConfirmPassword] span")
    private WebElement confirmPasswordError;



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
        return this;
    }

    public HomePage verifyRegistrationCompletion(String newEmail){
        softAssertion.assertEquals(registerNotification.getText().trim(), "Your registration completed");
        softAssertion.assertEquals(accountLink.getText().trim(), newEmail);
        return new HomePage();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public <T> T clickRegisterButton(Class<T> expectedPage){
        registerButton.click();
        return PageFactory.initElements(driver, expectedPage);
    }

    public Register verifyFirstNameErrorMessage(){
        softAssertion.assertTrue(firstNameError.isDisplayed());
        softAssertion.assertEquals(firstNameError.getText(), "First name is required.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyLastNameErrorMessage(){
        softAssertion.assertTrue(lastNameError.isDisplayed());
        softAssertion.assertEquals(lastNameError.getText(), "Last name is required.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyEmailErrorMessage(){
        softAssertion.assertTrue(emailError.isDisplayed());
        softAssertion.assertEquals(emailError.getText(), "Email is required.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyWrongEmailErrorMessage(){
        softAssertion.assertTrue(emailError.isDisplayed());
        softAssertion.assertEquals(emailError.getText(), "Wrong email");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyPasswordErrorMessage(){
        softAssertion.assertTrue(passwordError.isDisplayed());
        softAssertion.assertEquals(passwordError.getText(), "Password is required.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyShortPasswordErrorMessage(){
        softAssertion.assertTrue(passwordError.isDisplayed());
        softAssertion.assertEquals(passwordError.getText(), "The password should have at least 6 characters.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyConfirmPasswordErrorMessage(){
        softAssertion.assertTrue(confirmPasswordError.isDisplayed());
        softAssertion.assertEquals(confirmPasswordError.getText(), "Password is required.");
        softAssertion.assertAll();
        return this;
    }

    public Register verifyDifferentConfirmPasswordErrorMessage(){
        softAssertion.assertTrue(confirmPasswordError.isDisplayed());
        softAssertion.assertEquals(confirmPasswordError.getText(), "The password and confirmation password do not match.");
        softAssertion.assertAll();
        return this;
    }
}
