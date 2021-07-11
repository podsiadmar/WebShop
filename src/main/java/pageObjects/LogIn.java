package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn extends Base {

    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(className = "login-button")
    private WebElement loginButton;

    public HomePage logInToApplication(String email, String password){
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }



}
