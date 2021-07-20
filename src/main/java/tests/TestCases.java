package tests;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.Random;


public class TestCases extends BaseTest {

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

