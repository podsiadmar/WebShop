package tests;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.Random;


public class TestCases extends BaseTest {

    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void loginToShop(String login, String password){
        new HomePage()
                .proceedToLogin()
                .logInToApplication(login, password)
                .logOut();
    }

    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void registerNewUser(String fName, String lName, String eMail) {
        new HomePage()
                .proceedToRegister()
                .registerNewUser("M", fName, lName, eMail, "Tosca1234!", "Tosca1234!")
                .verifyRegistrationCompletion(eMail)
                .logOut();
    }

    @Test
    public void verifyProductPrice() {
        HomePage homePage = new HomePage();
        homePage
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .selectCategory("Apparel & Shoes")
                .selectProduct("Wool Hat")
                .addQuantity(12)
                .selectSize("Large")
                .clickAddToCart();
        homePage
                .proceedToShopingCart()
                .verifySubTotalPrice()
                .removeFirstProduct()
                .verifyShoppingCartIsEmpty();
        homePage
                .logOut();

    }

    @Test
    public void checkoutProcess() {
        HomePage homePage = new HomePage();
        homePage
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .selectCategory("Apparel & Shoes")
                .selectProduct("Sunglasses")
                .addQuantity(6)
                .clickAddToCart();
        homePage
                .proceedToShopingCart()
                .verifySubTotalPrice()
                .startCheckout()
                .pressContinueBillingAddress()
                .pressContinueShippingAddress()
                .selectGroundShippingMethod()
                .pressContinueShippingMethod()
                .selectCheckMoneyOrderPaymentMethod()
                .pressContinuePaymentMethod()
                .pressContinuePaymentInformation()
                .verifyCartTotalOrder()
                .pressConfirm();
        homePage
                .logOut();
    }


}

