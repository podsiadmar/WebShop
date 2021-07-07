package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;

public class BaseTest {
    //Declare class fields
    private WebDriver driver;
    protected Faker faker;
    protected HomePage homePage;
    protected LogIn logInLogout;
    protected Register register;
    protected Products products;
    protected ShoppingCart shopping_cart;
    protected CheckoutOrder checkout_order;

    @BeforeMethod
    public void setUp() {
        //Initialize faker
        faker = new Faker();

        //Initialize pages
        homePage = new HomePage();
        logInLogout = new LogIn();
        register = new Register();
        products = new Products();
        shopping_cart = new ShoppingCart();
        checkout_order = new CheckoutOrder();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
