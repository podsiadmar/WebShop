package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.*;

import java.sql.SQLException;

public class withoutExtend {
    //Declare class fields
    private WebDriver driver;
    protected Database database;

    @BeforeMethod
    public void setUp() {

        //Set driver, check path and chrome version
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        database = new Database(driver);

    }
    @Test
    public void databaseTesting() throws SQLException {
        database
                .ConnectToDatabase();
    }
}