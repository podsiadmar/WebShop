package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogIn;
import pageObjects.MyAccount.Addresses;

public class MyAccountScenario extends BaseTest {

    @Test(dataProvider = "NewAddress", dataProviderClass = DataProviders.class)
    public void proceedToMyAccount(String fname, String lname, String email, String company, String city,
                                   String address1, String address2, String zipCode, String phoneNumber, String faxNumber){
        new HomePage()
                .proceedToLogin()
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .proceedToMyAccount()
                .selectFromLeftList("Addresses");
        new Addresses()
                .clickAddNewButton()
                .fillNewAddressFormula(fname, lname, email, company, "Germany", city, address1, address2 ,zipCode
                        , phoneNumber, "Other (Non US)", faxNumber)
                .clickSaveButton();
        new Addresses()
                .verifyNewlyCreatedAddress(fname, lname, email, company, "Germany", city, address1, address2,
                        zipCode, phoneNumber, faxNumber);

    }
}
