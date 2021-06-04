package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Home_Page extends Base{

        //Top Menu Links
        @FindBy(linkText = "Log in")
        private WebElement logInLink;
        @FindBy(linkText = "Log out")
        private WebElement logOutLink;
        @FindBy(linkText = "egister")
        private WebElement registerLink;

        public Home_Page(WebDriver driver) {super(driver);}


        public Home_Page proceedToLogin(){
            logInLink.click();
            Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).isDisplayed());
            return this;
        }

        public Home_Page logOut(){
            logOutLink.click();
            Assert.assertTrue(logInLink.isDisplayed());
            return this;
        }


        public Home_Page proceedToRegister(){
            registerLink.click();
            Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Register']")).isDisplayed());
            return this;
        }


}
