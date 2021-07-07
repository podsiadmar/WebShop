package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverProvider {
    private static final String URL = "http://demowebshop.tricentis.com/";
    private static WebDriver driver;

    public static WebDriver getInstance(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();

            //Open Chrome
            driver = new ChromeDriver();

            driver.get(URL);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(10, TimeUnit.SECONDS)
                    .pageLoadTimeout(10, TimeUnit.SECONDS)
                    .setScriptTimeout(10, TimeUnit.SECONDS);
            driver.manage()
                    .window()
                    .maximize();
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }


}
