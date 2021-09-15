package pageObjects.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Base;
import java.util.List;
import java.util.Random;

public class Addresses extends Base {
    private static Integer blockOfAddressesCount;

    @FindBy(css = ".add-address-button")
    private WebElement addNewButton;

    @FindBy(css = ".address-item:last-child li")
    private List<WebElement> lastAddressInfo;

    @FindBy(css = ".address-item")
    private List<WebElement> addressBlock;

    @FindBy(css = "[value=Delete]")
    private List<WebElement> deleteButtons;

    public AddNewAddress<Addresses> clickAddNewButton(){
        addNewButton.click();
        return new AddNewAddress<>(this);
    }

    public Addresses verifyNewlyCreatedAddress(String firstName, String lastName, String email, String company, String country,
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
        return this;
    }

    public Addresses takeCountOfAllAddresses(){
        List<WebElement> blocks = addressBlock;
        blockOfAddressesCount = blocks.size();
        return this;
    }

    public void verifyAddressBlocksCount(){
        List<WebElement> blocks = addressBlock;
        Integer newCount = blocks.size();
        softAssertion.assertNotEquals(blockOfAddressesCount, newCount);
        softAssertion.assertTrue(blockOfAddressesCount+1==newCount);
        softAssertion.assertAll();
    }

    public void verifyAddressBlocksCount1(){
        List<WebElement> blocks = addressBlock;
        Integer newCount = blocks.size();
        softAssertion.assertNotEquals(blockOfAddressesCount, newCount);
        //waitDriver.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[value=Delete]"), newCount)));
        softAssertion.assertTrue(blockOfAddressesCount-1==newCount);
        softAssertion.assertAll();
    }

    public void removeRandomAddress(){
        List<WebElement> delete = deleteButtons;
        Random rnd = new Random();
        int bound = delete.size()-1;
        delete.get(rnd.nextInt(bound)).click();
    }
}
