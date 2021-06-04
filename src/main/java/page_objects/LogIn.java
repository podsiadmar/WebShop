package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogIn extends Base {

    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButton;



    public LogIn(WebDriver driver) {super(driver);}

    public void logInToApplication(String email, String password){
        Assert.assertTrue(emailTextBox.isEnabled());
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        driver.findElement(By.linkText("Log out")).isDisplayed();
    }

}
