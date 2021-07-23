package tests;

import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.HomePage;
import pageObjects.LogIn;

public class LoginScenario extends BaseTest {
    String wrongUser = "WrongLogin@login.com";
    String wrongPassword = "WrongPassword";

    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void loginToShopWithSuccess(String login, String password){
        new HomePage()
                .proceedToLogin()
                .logInToApplication(login, password)
                .verifyThatUserHasLoggedIn()
                .logOut();
    }

    @Test
    public void loginWithoutCredentials(){
        new HomePage()
                .proceedToLogin()
                .clickLoginButton()
                .verifyLoginValidationError()
                .verifyThatAccountWasNotFound();
    }

    @Test
    public void loginWithWrongCredentials(){
        new HomePage()
                .proceedToLogin()
                .logInToApplication(wrongUser, wrongPassword);
        new LogIn()
                .verifyLoginValidationError()
                .verifyThatAccountWasNotFound();
    }

    @Test
    public void loginWithWrongPassword(){
        new HomePage()
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", wrongUser);
        new LogIn()
                .verifyLoginValidationError()
                .verifyThatUserProvidesWrongCredentials();
    }

    @Test
    public void loginWithWrongEmail(){
        new HomePage()
                .proceedToLogin()
                .logInToApplication("WrongEmail", wrongPassword);
        new LogIn()
                .verifyEmailErrorValidationMessage();

    }

}
