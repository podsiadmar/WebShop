package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ChromePopUps extends Base {
    WebDriverWait wait = new WebDriverWait(this.driver,30);

    public void acceptChromePopUp(){
        Alert alert = driver.switchTo().alert();
        changeTimeouts(30);
        alert.accept();
        changeTimeouts(10);
    }
}
