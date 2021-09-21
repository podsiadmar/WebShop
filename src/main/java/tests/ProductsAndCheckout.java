package tests;
import generators.DataProviders;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Products;

import java.util.Random;


public class ProductsAndCheckout extends BaseTest {

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

    @Test(dataProvider = "amountsPerPage", dataProviderClass = DataProviders.class)
    public void checkProductAmountPerPage(Integer pageAmount){
        HomePage homePage = new HomePage();
        Products products = new Products();
        homePage
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .selectCategory("Apparel & Shoes")
                .selectDisplayPerPageAmount(pageAmount)
                .getCountOfVisibleProducts();
        products
                .verifyProductAmmount(pageAmount);
    }

    @Test
    public void verifyPriceSortingLowToHigh(){
        HomePage homePage = new HomePage();
        homePage
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .selectCategory("Apparel & Shoes")
                .selectProductSort("Price: Low to High")
                .verifyPriceSortingLowToHigh();
        homePage
                .logOut();

    }

    @Test
    public void verifyPriceSortingHighToLow(){
        HomePage homePage = new HomePage();
        homePage
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .selectCategory("Apparel & Shoes")
                .selectProductSort("Price: High to Low")
                .verifyPriceSortingHighToLow();
        homePage
                .logOut();

    }


}

