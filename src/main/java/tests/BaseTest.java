package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import page_objects.*;

public class BaseTest {
    //Declare class fields
    private WebDriver driver;
    protected Faker faker;
    protected Home_Page homePage;
    protected LogIn logInLogout;
    protected Register register;
    protected Products products;
    protected Shopping_Cart shopping_cart;
    protected Checkout_Order checkout_order;

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

        //Initialize faker
        faker = new Faker();

        //Initialize pages
        homePage = new Home_Page(driver);
        logInLogout = new LogIn(driver);
        register = new Register(driver);
        products = new Products(driver);
        shopping_cart = new Shopping_Cart(driver);
        checkout_order = new Checkout_Order(driver);
    }

//    @AfterMethod
//    public void tearDown() {driver.quit();}
}
