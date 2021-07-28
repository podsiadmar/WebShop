package pageObjects.MyAccount;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base;

import java.util.List;
import java.util.stream.Collectors;

public class MyAccountMain extends Base {

    @FindBy(css = ".block-account-navigation .list li a")
    private List<WebElement> accountNavigation;


    public void selectFromLeftList(String accountOption){
        List<WebElement> temp = accountNavigation
                .stream()
                .filter(webElement -> webElement.getText().contains(accountOption))
                .collect(Collectors.toList());
        if(temp.isEmpty()) throw new InvalidArgumentException("Invalid account option name");
        temp.get(0).click();

    }

    public <T> T selectFromLeftList(String accountOption, Class<T> expectedPage){
        List<WebElement> temp = accountNavigation
                .stream()
                .filter(webElement -> webElement.getText().contains(accountOption))
                .collect(Collectors.toList());
        if(temp.isEmpty()) throw new InvalidArgumentException("Invalid account option name");
        temp.get(0).click();
        return PageFactory.initElements(driver, expectedPage);
    }


}

