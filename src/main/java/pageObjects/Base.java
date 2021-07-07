package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class Base {
    private static final String URL = "http://demowebshop.tricentis.com/";
    protected WebDriver driver;

    public Base() {
        //Set driver, check path and chrome version
        WebDriverManager.chromedriver().setup();

        //Open Chrome
        this.driver = new ChromeDriver();

        driver.get(URL);
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS)
                .setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage()
                .window()
                .maximize();

        //Initialize PageFactory elements defined in @FindBy annotations
        PageFactory.initElements(driver, this);
    }

}

