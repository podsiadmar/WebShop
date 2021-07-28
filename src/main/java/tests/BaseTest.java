package tests;

import Security.Vault;
import configuration.WebDriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    //Declare class fields
    protected Vault vault;

    @BeforeMethod
    public void setUp() {
        vault = new Vault();

    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeDriver();
    }

}
