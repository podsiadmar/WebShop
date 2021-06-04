package tests;

import org.testng.annotations.Test;
import page_objects.Home_Page;

public class Test_Package1 extends BaseTest {

    @Test
    public void loginToShop(){
        homePage
                .proceedToLogin();
        logIn
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!");
        homePage
                .logOut();

    }

    @Test
    public void registerNewUser(){
        homePage
                .proceedToRegister();

    }

}
