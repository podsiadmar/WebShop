package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Base {
    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;

        //Initialize PageFactory elements defined in @FindBy annotations
        PageFactory.initElements(driver, this);
    }
}

