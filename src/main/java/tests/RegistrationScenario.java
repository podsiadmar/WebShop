package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Register;

public class RegistrationScenario extends BaseTest{

    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void registerNewUser(String fName, String lName, String eMail) {
        new HomePage()
                .proceedToRegister()
                .registerNewUser("M", fName, lName, eMail, "Tosca1234!", "Tosca1234!")
                .clickRegisterButton(Register.class)
                .verifyRegistrationCompletion(eMail)
                .logOut();
    }

    @Test
    public void verifyRegistrationErrors(){
        new HomePage()
                .proceedToRegister()
                .clickRegisterButton(Register.class)
                .verifyEmailErrorMessage()
                .verifyFirstNameErrorMessage()
                .verifyLastNameErrorMessage()
                .verifyPasswordErrorMessage()
                .verifyConfirmPasswordErrorMessage()
                .registerNewUser("M", "D", "D", "D", "D", "F")
                .verifyWrongEmailErrorMessage()
                .verifyShortPasswordErrorMessage()
                .verifyDifferentConfirmPasswordErrorMessage();

    }
}
