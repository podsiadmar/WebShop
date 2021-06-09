package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;

        //Initialize PageFactory elements defined in @FindBy annotations
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

