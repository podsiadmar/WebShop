package tests;

import generators.AddressGenerator;
import generators.DataProviders;
import org.testng.annotations.Test;
import pageObjects.ChromePopUps;
import pageObjects.HomePage;
import pageObjects.MyAccount.Addresses;

import java.io.IOException;

public class MyAccountScenario extends BaseTest {


    private Object Addresses;

    @Test(dataProvider = "NewAddress", dataProviderClass = DataProviders.class)
    public void proceedToMyAccount(String fname, String lname, String email, String company, String country, String province,
                                   String city, String address1, String address2, String zipCode, String phoneNumber,
                                   String faxNumber) throws IOException {
        new HomePage()
                .proceedToLogin()
                .logInToApplication(vault.getDataValue("login"), vault.getDataValue("password"))
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
    public void removeRandomAddress() throws IOException {
        new HomePage()
                .proceedToLogin()
                .logInToApplication(vault.getDataValue("login"), vault.getDataValue("password"))
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

