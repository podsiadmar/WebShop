package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class Checkout_Order extends Base{
    public Checkout_Order(WebDriver driver) {super(driver);}

    //Billing address
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingAddressCountry;
    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingAddressCity;
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddressAddress1;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingAddressPostalCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingAddressPhoneNumber;

    //Shipping Method
    @FindBy(xpath = "//label[contains(text(), 'Ground')]/preceding-sibling::input")
    private WebElement shippingMethodGround;
    @FindBy(xpath = "//label[contains(text(), 'Next Day Air')]/preceding-sibling::input")
    private WebElement shippingMethodNextDayAir;
    @FindBy(xpath = "//label[contains(text(), '2nd Day Air')]/preceding-sibling::input")
    private WebElement shippingMethod2ndDayAir;

    //Payment method
    @FindBy(xpath = "//label[contains(text(), 'Cash On Delivery')]/preceding-sibling::input")
    private WebElement paymentMethodCashOnDelivery;
    @FindBy(xpath = "//label[contains(text(), 'Check')]/preceding-sibling::input")
    private WebElement paymentMethodCheck;
    @FindBy(xpath = "//label[contains(text(), 'Credit Card')]/preceding-sibling::input")
    private WebElement paymentMethodCreditCard;
    @FindBy(xpath = "//label[contains(text(), 'Purchase Order')]/preceding-sibling::input")
    private WebElement paymentMethodPurchaseOrder;

    //Buttons
    @FindBy(xpath = "//input[@type='button' and @title='Continue'][@onclick='Billing.save()']")
    private WebElement continueButtonBilling;
    @FindBy(xpath = "//input[@type='button' and @title='Continue'][@onclick='Shipping.save()']")
    private WebElement continueButtonShipping;
    @FindBy(xpath = "//input[@type='button' and @value='Continue'][@onclick='ShippingMethod.save()']")
    private WebElement continueButtonShippingMethod;
    @FindBy(xpath = "//input[@type='button' and @value='Continue'][@onclick='PaymentMethod.save()']")
    private WebElement continueButtonPaymentMethod;
    @FindBy(xpath = "//input[@type='button' and @value='Continue'][@onclick='PaymentInfo.save()']")
    private WebElement continueButtonPaymentInformation;
    @FindBy(xpath = "//input[@value='Confirm']")
    private WebElement confirmButton;

    //Order Completed
    @FindBy(xpath = "//div[@class='section order-completed']")
    private WebElement orderCompletionSection;

    //here i tried to create one general xpath to take all continue buttons and put it into list, then i use for to check all buttons
    // and click the visible one, unfortunatelly doesn work
    @FindBy(xpath = "//input[@type='button' and @title='Continue' or @value='Continue' and contains(@onclick, '.save')]")
    private List<WebElement> continueBtns;

    public Checkout_Order clickContinue() throws InterruptedException {
        for (WebElement btn : continueBtns){
            if(btn.isEnabled()){
                Thread.sleep(1000);
                btn.click();
                break;
            }
        }
        return this;
    }

    //doesnt work on webshop, tried to put all buttons into one array then click the enable one
    public Checkout_Order pressContinue() throws InterruptedException {
        WebElement btns[] = new WebElement[] {continueButtonBilling, continueButtonShipping,continueButtonPaymentInformation, continueButtonPaymentMethod, continueButtonShippingMethod};
        for(WebElement btn : btns){
            if (btn.isEnabled()){
                Thread.sleep(1000);
                btn.click();
                break;
            }
        }
        return this;
    }

    public Checkout_Order pressContinueBillingAddress() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(continueButtonBilling.isDisplayed());
        continueButtonBilling.click();
    return this;
    }

    public Checkout_Order pressContinueShippingAddress() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(continueButtonShipping.isDisplayed());
        continueButtonShipping.click();
        return this;
    }

    public Checkout_Order pressContinueShippingMethod() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(continueButtonShippingMethod.isDisplayed());
        continueButtonShippingMethod.click();
        return this;
    }

    public Checkout_Order pressContinuePaymentMethod() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(continueButtonPaymentMethod.isDisplayed());
        continueButtonPaymentMethod.click();
        return this;
    }

    public Checkout_Order pressContinuePaymentInformation() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(continueButtonPaymentInformation.isDisplayed());
        continueButtonPaymentInformation.click();
        return this;
    }

    public Checkout_Order pressConfirm(){
        Assert.assertTrue(confirmButton.isDisplayed());
        confirmButton.click();
        Assert.assertTrue(orderCompletionSection.isDisplayed());
        return this;
    }

    public Checkout_Order selectShippingMethod(String shippingMethod){
        switch (shippingMethod){
            case "Ground":
                Assert.assertTrue(shippingMethodGround.isDisplayed());
                shippingMethodGround.click();
                break;
            case "Next Day Air":
                Assert.assertTrue(shippingMethod2ndDayAir.isDisplayed());
                shippingMethodNextDayAir.click();
                break;
            case "2nd Day Air":
                Assert.assertTrue(shippingMethod2ndDayAir.isDisplayed());
                shippingMethod2ndDayAir.click();
                break;
        }
        return this;
    }

    public Checkout_Order selectPaymentMethod(String paymentMethod){
        switch (paymentMethod){
            case "Cash On Delivery":
                Assert.assertTrue(paymentMethodCashOnDelivery.isDisplayed());
                paymentMethodCashOnDelivery.click();
                break;
            case "Check / Money Order":
                Assert.assertTrue(paymentMethodCheck.isDisplayed());
                paymentMethodCheck.click();
                break;
            case "Credit Card":
                Assert.assertTrue(paymentMethodCreditCard.isDisplayed());
                paymentMethodCreditCard.click();
                break;
            case "Purchase Order":
                Assert.assertTrue(paymentMethodPurchaseOrder.isDisplayed());
                paymentMethodPurchaseOrder.click();
                break;

        }
        return this;
    }

    public double getMethodPrice(String methodForPrice){
        String label = driver.findElement(By.xpath("//label[contains(text(), '"+methodForPrice+"')]")).getText();
        Integer leftBracket = label.indexOf("(");
        Integer rightBracket = label.indexOf(")");
        String priceTrimmed = label.substring(leftBracket+1, rightBracket);
        Double paymentMethodPrice = Double.valueOf(priceTrimmed);
        return paymentMethodPrice;
    }

    public double getOrderSubTotalPrice(){
        String subTotal = driver.findElement(By.xpath("//span[text()='Sub-Total:']/ancestor::td/following-sibling::td//span[@class='product-price']")).getText();
        Double orderSubTotalPrice = Double.valueOf(subTotal);
        return orderSubTotalPrice;
    }

    public double getOrderTotalPrice(){
        String totalPrice = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong")).getText();
        Double orderTotalPrice = Double.valueOf(totalPrice);
        return orderTotalPrice;
    }


}
