package pageObjects.MyAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Base;

import java.util.List;

public class Addresses extends Base {

    @FindBy(css = ".add-address-button")
    private WebElement addNewButton;

    @FindBy(css = ".address-item:last-child li")
    private List<WebElement> lastAddressInfo;

    public AddNewAddress clickAddNewButton(){
        addNewButton.click();
        return new AddNewAddress();
    }

    public void verifyNewlyCreatedAddress(String firstName, String lastName, String email, String company, String country,
                                          String city, String address1, String address2, String postalCode, String phoneNumber,
                                          String faxNumber){
        List<WebElement> temp = lastAddressInfo;
        softAssertion.assertEquals(temp.get(0).getText(), firstName+" "+lastName);
        softAssertion.assertTrue(temp.get(1).getText().contains(email));
        softAssertion.assertTrue(temp.get(2).getText().contains(phoneNumber));
        softAssertion.assertTrue(temp.get(3).getText().contains(faxNumber));
        softAssertion.assertEquals(temp.get(4).getText(), company);
        softAssertion.assertEquals(temp.get(5).getText(), address1);
        softAssertion.assertEquals(temp.get(6).getText(), address2);
        softAssertion.assertEquals(temp.get(7).getText(), city+", "+postalCode);
        softAssertion.assertEquals(temp.get(8).getText(), country);
        softAssertion.assertAll();
    }
}
