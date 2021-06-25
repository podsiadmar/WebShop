package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Database;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;


public class Test_Package1 extends BaseTest {

    @Test
    public void loginToShop(){
        homePage
                .proceedToLogin();
        logInLogout
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!");
        homePage
                .logOut();

    }

    @Test
    public void registerNewUser(){
        homePage
                .proceedToRegister();

        //Randomize first name, last name and compose email address
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String nMail = fName+"."+lName+"@gmail.test";
        System.out.println(fName+", "+lName+", "+nMail);

        register
                .registerNewUser("M", fName, lName, nMail, "Pass1234!", "Pass1234!")
                .verifyRegistrationCompletion(nMail);
    }

    @Test
    public void verifyProductPrice() throws InterruptedException {
        homePage
                .proceedToLogin();
        logInLogout
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!");
        homePage
                .selectCategory("Apparel & Shoes");
        int int_random = ThreadLocalRandom.current().nextInt(1, 30);
        products
                .selectProduct("Wool Hat")
                .addQuantity(int_random)
                .selectSize("Large")
                .clickAddToCart();
        homePage
                .proceedToShopingCart();
        shopping_cart
                .verifySubTotalPrice()
                .removeFirstProduct()
                .verifyShoppingCartIsEmpty();

    }

    @Test
    public void checkoutProcess() throws InterruptedException {
        homePage
                .proceedToLogin();
        logInLogout
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!");
        homePage
                .selectCategory("Apparel & Shoes");
        int int_random = ThreadLocalRandom.current().nextInt(1, 30);
        products
                .selectProduct("Sunglasses")
                .addQuantity(int_random)
                .clickAddToCart();
        homePage
                .proceedToShopingCart();
        shopping_cart
                .verifySubTotalPrice()
                .startCheckout();
        checkout_order
                .pressContinueBillingAddress()
                .pressContinueShippingAddress()
                .selectShippingMethod("Ground");
        double shippingMethodPrice = checkout_order.getMethodPrice("Ground");
        checkout_order
                .pressContinueShippingMethod()
                .selectPaymentMethod("Check / Money Order");
        double paymentMethodPrice = checkout_order.getMethodPrice("Check / Money Order");
        checkout_order
                .pressContinuePaymentMethod()
                .pressContinuePaymentInformation();
        double orderSubTotalPrice = checkout_order.getOrderSubTotalPrice();
        double orderTotalPrice = checkout_order.getOrderTotalPrice();
        Assert.assertTrue(shippingMethodPrice + paymentMethodPrice + orderSubTotalPrice == orderTotalPrice);
        checkout_order
                .pressConfirm();
        homePage
                .logOut();
    }

    @Test
    public void dataTest() throws SQLException {
        database
                .ConnectToDatabase();
    }

}

