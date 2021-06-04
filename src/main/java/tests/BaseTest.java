package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page_objects.Home_Page;
import page_objects.LogIn;
import page_objects.Register;

public class BaseTest {
    //Declare class fields
    private WebDriver driver;
    protected Home_Page homePage;
    protected LogIn logIn;
    protected Register register;

    @BeforeMethod
    public void setUp(){

        //Set driver, check path and chrome version
        WebDriverManager.chromedriver().setup();

        //Open Chrome
        driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Open URL
        driver.get("http://demowebshop.tricentis.com/");

        //Initialize pages
        homePage = new Home_Page(driver);
        logIn = new LogIn(driver);
        register = new Register(driver);
    }

//    @AfterMethod
//    public void tearDown() {driver.quit();}
}
