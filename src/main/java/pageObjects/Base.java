package pageObjects;

import com.github.javafaker.Faker;
import configuration.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Base {
    protected WebDriver driver;
    protected SoftAssert softAssertion = new SoftAssert();
    protected WebDriverWait waitDriver;

    public Base() {
        //Set driver, check path and chrome version
        this.driver = WebDriverProvider.getInstance();

        //Initialize PageFactory elements defined in @FindBy annotations
        PageFactory.initElements(driver, this);

        waitDriver = new WebDriverWait(driver,15);
    }

    public void turnOffImplicitWaits(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void turnOnImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void changeTimeouts(int timeout){
        driver.manage().timeouts()
                .pageLoadTimeout(timeout, TimeUnit.SECONDS)
                .setScriptTimeout(timeout, TimeUnit.SECONDS);
    }


}

