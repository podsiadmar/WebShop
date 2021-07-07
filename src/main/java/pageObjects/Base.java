package pageObjects;

import configuration.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class Base {
    protected WebDriver driver;

    public Base() {
        //Set driver, check path and chrome version
        this.driver = WebDriverProvider.getInstance();

        //Initialize PageFactory elements defined in @FindBy annotations
        PageFactory.initElements(driver, this);
    }

}

