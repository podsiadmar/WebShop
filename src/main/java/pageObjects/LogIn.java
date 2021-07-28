package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogIn extends Base {

    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(className = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".validation-summary-errors span")
    private WebElement loginValidationError;
    @FindBy(css = ".validation-summary-errors li")
    private WebElement errorValidationReason;
    @FindBy(css = "[data-valmsg-for=Email] span")
    private WebElement emailErrorMessage;

    public HomePage logInToApplication(String email, String password){
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public LogIn clickLoginButton(){
        loginButton.click();
        return this;
    }

    public LogIn verifyLoginValidationError(){
        Assert.assertTrue(loginValidationError.isDisplayed());
        Assert.assertEquals(loginValidationError.getText(), "Login was unsuccessful. " +
                "Please correct the errors and try again.");
        return this;
    }

    public LogIn verifyThatAccountWasNotFound(){
        Assert.assertTrue(errorValidationReason.isDisplayed());
        Assert.assertEquals(errorValidationReason.getText(), "No customer account found");
        return this;
    }

    public LogIn verifyThatUserProvidesWrongCredentials(){
        Assert.assertTrue(errorValidationReason.isDisplayed());
        Assert.assertEquals(errorValidationReason.getText(), "The credentials provided are incorrect");
        return this;
    }

    public LogIn verifyEmailErrorValidationMessage(){
        Assert.assertTrue(emailErrorMessage.isDisplayed());
        Assert.assertEquals(emailErrorMessage.getText(), "Please enter a valid email address.");
        return this;
    }

}
