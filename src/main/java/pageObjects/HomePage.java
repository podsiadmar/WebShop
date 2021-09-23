package pageObjects;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MyAccount.MyAccountMain;

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
        @FindBy(css = ".header-links .account")
        private WebElement accountLink;
        @FindBy(css = ".block-category-navigation .list li a")
        private List<WebElement> categories;

        public LogIn proceedToLogin(){
            logInLink.click();
            return new LogIn();
        }

        public HomePage logOut(){
            logOutLink.click();
            return new HomePage();
        }

        public Register proceedToRegister(){
            registerLink.click();
            return new Register();
        }

    public MyAccountMain proceedToMyAccount(){
        accountLink.click();
        return new MyAccountMain();
    }

        public ShoppingCart proceedToShopingCart(){
            turnOffImplicitWaits();
            WebDriverWait wait = new WebDriverWait(driver, 10 , 500);
            wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
            turnOnImplicitWaits();
            shoppingCartLink.click();
            return new ShoppingCart();
        }

        public Products selectCategory(String categoryName){
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
            return new Products();
        }

    public HomePage verifyThatUserHasLoggedIn(){
    softAssertion.assertTrue(logOutLink.isDisplayed());
    softAssertion.assertTrue(accountLink.isDisplayed());
    softAssertion.assertAll();
    return this;
    }
}
