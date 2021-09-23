package BDD.stepDefinitions;

import configuration.WebDriverProvider;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Base;
import pageObjects.HomePage;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {

    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(className = "login-button")
    private WebElement loginButton;
    @FindBy(linkText = "Log out")
    private WebElement logOutLink;
    @FindBy(linkText = "Log in")
    private WebElement logInLink;

@Given("^Newly opened chrome browser$")
    public void newly_opened_chrome_browser(){
        driver = WebDriverProvider.getInstance();
    System.out.println("1");
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1){
        WebDriverProvider.getInstance();
        driver.get("http://demowebshop.tricentis.com/");
        System.out.println("2");
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public HomePage user_enters_and_and_logs_in(String username, String password){
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        System.out.println("4");
        return new HomePage();
    }

    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in(){
        Assert.assertTrue(logOutLink.isDisplayed());
        System.out.println("5");
    }

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page(){
        logInLink.click();
        System.out.println("3");
    }

    @And("^close browsers$")
    public void close_browsers(){
        System.out.println("6");
        WebDriverProvider.closeDriver();
    }
}

