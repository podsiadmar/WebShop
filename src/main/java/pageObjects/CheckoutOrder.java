package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOrder extends Base{

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
    @FindBy(xpath = "[@onclick='PaymentInfo.save()']")
    private WebElement continueButtonPaymentInformation;
    @FindBy(css = "[value='Confirm']")
    private WebElement confirmButton;

    //Order Completed
    @FindBy(xpath = "//div[@class='section order-completed']")
    private WebElement orderCompletionSection;

    //here i tried to create one general xpath to take all continue buttons and put it into list, then i use for to check all buttons
    // and click the visible one, unfortunatelly doesn work
    @FindBy(xpath = "//input[@type='button' and @title='Continue' or @value='Continue' and contains(@onclick, '.save')]")
    private List<WebElement> continueBtns;

    public CheckoutOrder clickContinue() {
        for (WebElement btn : continueBtns){
            if(btn.isEnabled()){
                btn.click();
                break;
            }
        }
        return this;
    }

    //doesn't work on webshop, tried to put all buttons into one array then click the enable one
    public CheckoutOrder pressContinue() {
        WebElement[] btns = new WebElement[] { continueButtonBilling, continueButtonShipping,
                continueButtonPaymentInformation, continueButtonPaymentMethod, continueButtonShippingMethod
        };
        for(WebElement btn : btns){
            if (btn.isEnabled()){
                btn.click();
                break;
            }
        }
        return this;
    }

    public CheckoutOrder pressContinueBillingAddress() {
        continueButtonBilling.click();
        return this;
    }

    public CheckoutOrder pressContinueShippingAddress() {
        continueButtonShipping.click();
        return this;
    }

    public CheckoutOrder pressContinueShippingMethod() {
        continueButtonShippingMethod.click();
        return this;
    }

    public CheckoutOrder pressContinuePaymentMethod() {
        continueButtonPaymentMethod.click();
        return this;
    }

    public CheckoutOrder pressContinuePaymentInformation() {
        continueButtonPaymentInformation.click();
        return this;
    }

    public CheckoutOrder pressConfirm(){
        confirmButton.click();
        return this;
    }

    public CheckoutOrder selectShippingMethod(String shippingMethod){
        switch (shippingMethod){
            case "Ground":
                shippingMethodGround.click();
                break;
            case "Next Day Air":
                shippingMethodNextDayAir.click();
                break;
            case "2nd Day Air":
                shippingMethod2ndDayAir.click();
                break;
        }
        return this;
    }

    public CheckoutOrder selectPaymentMethod(String paymentMethod){
        switch (paymentMethod){
            case "Cash On Delivery":
                paymentMethodCashOnDelivery.click();
                break;
            case "Check / Money Order":
                paymentMethodCheck.click();
                break;
            case "Credit Card":
                paymentMethodCreditCard.click();
                break;
            case "Purchase Order":
                paymentMethodPurchaseOrder.click();
                break;

        }
        return this;
    }

    public double getMethodPrice(String methodForPrice){
        String label = driver.findElement(By.xpath("//label[contains(text(), '"+methodForPrice+"')]")).getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket+1, rightBracket));
    }

    public double getOrderSubTotalPrice(){
        String subTotal = driver.findElement(By.xpath("//span[text()='Sub-Total:']/ancestor::td/following-sibling::td//span[@class='product-price']")).getText();
        return Double.parseDouble(subTotal);
    }

    public double getOrderTotalPrice(){
        return Double.parseDouble(driver.findElement(By.xpath("//span[@class='product-price order-total']/strong")).getText());
    }


}
