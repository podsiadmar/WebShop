package tests;

import generators.AddressGenerator;
import generators.DataProviders;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.ChromePopUps;
import pageObjects.HomePage;
import pageObjects.MyAccount.Addresses;

import java.io.IOException;

public class MyAccountScenario extends BaseTest {


    private Object Addresses;

    @Test(dataProvider = "NewAddress", dataProviderClass = DataProviders.class)
    public void addNewAddress(String fname, String lname, String email, String company, String country, String province,
                              String city, String address1, String address2, String zipCode, String phoneNumber,
                              String faxNumber) {
        new HomePage()
                .proceedToLogin()
//                .logInToApplication(vault.getDataValue("login"), vault.getDataValue("password"))
                .logInToApplication("JN.8i4201@gmail.test", "Tosca1234!")
                .proceedToMyAccount()
                .selectFromLeftList("Addresses", Addresses.class)
                .takeCountOfAllAddresses()
                .clickAddNewButton()
                .fillNewAddressFormula(fname, lname, email, company, country, city, address1, address2, zipCode
                        , phoneNumber, province, faxNumber)
                .clickSaveButton()
                .verifyNewlyCreatedAddress(fname, lname, email, company, country, city, address1, address2,
                        zipCode, phoneNumber, faxNumber)
                .verifyAddressBlocksCount();

    }
    @Test
    public void removeRandomAddress() {
        new HomePage()
                .proceedToLogin()
//                .logInToApplication(vault.getDataValue("login"), vault.getDataValue("password"))
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


