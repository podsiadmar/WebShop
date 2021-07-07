package pageObjects;

import jdk.jpackage.internal.Log;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Base {

        //Top Menu Links
        @FindBy(linkText = "Log in")
        private WebElement logInLink;
        @FindBy(linkText = "Log out")
        private WebElement logOutLink;
        @FindBy(linkText = "Register")
        private WebElement registerLink;
        @FindBy(partialLinkText = "Shopping cart")
        private WebElement shoppingCartLink;
        @FindBy(css = ".block-category-navigation .list li")
        private List<WebElement> categories;

        public LogIn proceedToLogin(){
            logInLink.click();
            return new LogIn();
        }

        public HomePage logOut(){
            logOutLink.click();
            return this;
        }

        public HomePage proceedToRegister(){
            registerLink.click();
            return this;
        }

        public HomePage proceedToShopingCart(){
            //turn off implicityWait
//            WebDriverWait wait = new WebDriverWait(driver, 10 , 500);
//            wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
            //turn on
            shoppingCartLink.click();
            return this;
        }

        public HomePage selectCategory(String categoryName){
            List<WebElement> temp = categories
                    .stream()
                    .filter(webElement -> webElement.getText().contains(categoryName))
                    .collect(Collectors.toList());

//            for(WebElement el : categories){
//                if(el.getText().contains(categoryName)) {
//                    el.click();
//                    return this;
//                }
//            }

            if(temp.isEmpty()) throw new InvalidArgumentException("Invalid category name.");
            temp.get(0).click();
            return this;
        }
}
