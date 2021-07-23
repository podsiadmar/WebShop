package tests;

import com.github.javafaker.Faker;
import configuration.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pageObjects.*;

public class BaseTest {
    //Declare class fields
    protected Faker faker;

    @BeforeMethod
    public void setUp() {
        //Initialize faker
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeDriver();
    }

}
