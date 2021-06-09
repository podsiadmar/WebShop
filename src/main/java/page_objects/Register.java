package page_objects;

import org.openqa.selenium.WebDriver;
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
    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerNotification;
    @FindBy(xpath = "//a[@class='account'][contains(text(), '@')]")
    public WebElement accountLink;

    public Register(WebDriver driver) {super(driver);}

    public Register registerNewUser(String gender, String firsName, String lastName, String eMail, String password, String confirmPassword){
        Assert.assertTrue(firstNameTextBox.isDisplayed());

        if (gender=="M"){
            maleRadioButton.click();
        }
        else if (gender=="F"){
            femaleRadioButton.click();
        }
        else {
            System.out.println("incorect data");
        }

        firstNameTextBox.sendKeys(firsName);
        lastNameTextBox.sendKeys(lastName);
        emailTextBox.sendKeys(eMail);
        passwordTextBox.sendKeys(password);
        confirmPasswordTextBox.sendKeys(confirmPassword);
        registerButton.click();
        return this;

    }

    public Register verifyRegistrationCompletion(String newEmail){
        String notificationText = registerNotification.getText().trim();
        Assert.assertEquals(notificationText, "Your registration completed");
        String accountLinkText =    accountLink.getText().trim();
        Assert.assertEquals(accountLinkText, newEmail);
        return this;
    }
}
