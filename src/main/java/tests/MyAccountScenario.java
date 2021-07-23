package tests;

import org.testng.annotations.Test;
import pageObjects.ChromePopUps;
import pageObjects.HomePage;
import pageObjects.LogIn;
import pageObjects.MyAccount.Addresses;
import pageObjects.MyAccount.Orders;

public class MyAccountScenario extends BaseTest {


    private Object Addresses;

    @Test(dataProvider = "NewAddress", dataProviderClass = DataProviders.class)
    public void proceedToMyAccount(String fname, String lname, String email, String company, String city,
                                   String address1, String address2, String zipCode, String phoneNumber, String faxNumber){
        new HomePage()
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .proceedToMyAccount()
                .selectFromLeftList("Addresses", Addresses.class)
                .takeCountOfAllAddresses()
                .clickAddNewButton()
                .fillNewAddressFormula(fname, lname, email, company, "Germany", city, address1, address2 ,zipCode
                        , phoneNumber, "Other (Non US)", faxNumber)
                .clickSaveButton()
                .verifyNewlyCreatedAddress(fname, lname, email, company, "Germany", city, address1, address2,
                        zipCode, phoneNumber, faxNumber)
                .verifyAddressBlocksCount();

    }

    @Test
    public void removeRandomAddress(){
        new HomePage()
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .proceedToMyAccount()
                .selectFromLeftList("Addresses", Addresses.class)
                .takeCountOfAllAddresses()
                .removeRandomAddress();
        new ChromePopUps()
                .acceptChromePopUp();
        new Addresses()
                .verifyAddressBlocksCount1();
    }
}
