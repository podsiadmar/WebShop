package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    //radio buttons
    @FindBy(css = "[value=\"Ground___Shipping.FixedRate\"]")
    private WebElement shippingMethodGround;
    @FindBy(xpath = "[value=\"Next Day Air___Shipping.FixedRate\"]")
    private WebElement shippingMethodNextDayAir;
    @FindBy(xpath = "[value=\"2nd Day Air___Shipping.FixedRate\"]")
    private WebElement shippingMethod2ndDayAir;
    //labels
    @FindBy(xpath = "//label[contains(text(), 'Ground')]")
    private WebElement shippingMethodGroundLabel;
    @FindBy(xpath = "//label[contains(text(), 'Next Day Air')]")
    private WebElement shippingMethodNextDayAirLabel;
    @FindBy(xpath = "//label[contains(text(), '2nd Day Air')]")
    private WebElement shippingMethod2ndDayAirLabel;


    //Payment method
    @FindBy(css = "[value=\"Payments.CashOnDelivery\"]")
    private WebElement paymentMethodCashOnDelivery;
    @FindBy(css = "[value=\"Payments.CheckMoneyOrder\"]")
    private WebElement paymentMethodCheck;
    @FindBy(css = "[value=\"Payments.Manual\"]")
    private WebElement paymentMethodCreditCard;
    @FindBy(css = "[value=\"Payments.PurchaseOrder\"]")
    private WebElement paymentMethodPurchaseOrder;
    //labels
    @FindBy(xpath = "//label[contains(text(), 'Cash On Delivery')]")
    private WebElement paymentMethodCashOnDeliveryLabel;
    @FindBy(xpath = "//label[contains(text(), 'Check / Money Order')]")
    private WebElement paymentMethodCashMoneyOrderLabel;
    @FindBy(xpath = "//label[contains(text(), 'Credit Card')]")
    private WebElement paymentMethodCreditCardLabel;
    @FindBy(xpath = "//label[contains(text(), 'Purchase Order')]")
    private WebElement paymentMethodPurchaseOrderLabel;


    //Buttons
    @FindBy(css = "[onclick=\"Billing.save()\"]")
    private WebElement continueButtonBilling;
    @FindBy(css = "[onclick=\"Shipping.save()\"]")
    private WebElement continueButtonShipping;
    @FindBy(css = "[onclick=\"ShippingMethod.save()\"]")
    private WebElement continueButtonShippingMethod;
    @FindBy(css = "[onclick=\"PaymentMethod.save()\"]")
    private WebElement continueButtonPaymentMethod;
    @FindBy(css = "[onclick=\"PaymentInfo.save()\"]")
    private WebElement continueButtonPaymentInformation;
    @FindBy(css = "[value='Confirm']")
    private WebElement confirmButton;

    //CartTotal
    @FindBy(css = "table.cart-total tr:first-of-type .product-price")
    private WebElement cartSubTotalPrice;
    @FindBy(css = "table.cart-total tr:nth-child(2) .product-price")
    private WebElement cartShippingPrice;
    @FindBy(css = "table.cart-total tr:nth-child(3) .product-price")
    private WebElement cartPaymentMethodAdditionalFeePrice;
    @FindBy(css = "table.cart-total tr:nth-child(4) .product-price")
    private WebElement cartTaxPrice;
    @FindBy(css = "table.cart-total tr:last-of-type .product-price")
    private WebElement cartTotalPrice;

    //Order Completed
    @FindBy(css = ".order-completed")
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
//---------------------------------------------------Shipping Methods---------------------------------------------------
    //Ground
    public CheckoutOrder selectGroundShippingMethod(){
        shippingMethodGround.click();
        return this;
    }

    public double getGroundMethodPrice() {
        String label = shippingMethodGroundLabel.getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket + 1, rightBracket));
    }
    //Next Day Air
    public CheckoutOrder selectNextDayAirShippingMethod(){
        shippingMethodNextDayAir.click();
        return this;
    }

    public double getNextDayAirMethodPrice() {
        String label = shippingMethodNextDayAirLabel.getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket + 1, rightBracket));
    }

    //2nd Day Air
    public CheckoutOrder select2ndDayAirShippingMethod(){
        shippingMethod2ndDayAir.click();
        return this;
    }

    public double get2NndDayAirMethodPrice() {
        String label = shippingMethod2ndDayAir.getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket + 1, rightBracket));
    }

//---------------------------------------------------Payment Methods---------------------------------------------------
//Cash On Delivery
    public CheckoutOrder selectCashOnDeliveryPaymentMethod(){
        paymentMethodCashOnDelivery.click();
        return this;
    }

    public double getCashOnDeliveryPaymentMethodPrice() {
        String label = paymentMethodCashOnDeliveryLabel.getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket + 1, rightBracket));
    }
//Check / Money Order
    public CheckoutOrder selectCheckMoneyOrderPaymentMethod(){
        paymentMethodCheck.click();
        return this;
    }

    public double getCheckMoneyOrderPaymentMethodPrice() {
        String label = paymentMethodCashMoneyOrderLabel.getText();
        int leftBracket = label.indexOf("(");
        int rightBracket = label.indexOf(")");
        return Double.parseDouble(label.substring(leftBracket + 1, rightBracket));
    }
//Credit Card
    public CheckoutOrder selectCreditCardPaymentMethod(){
        paymentMethodCreditCard.click();
        return this;
    }
//Purchase Order
    public CheckoutOrder selectPurchaseOrderPaymentMethod(){
        paymentMethodPurchaseOrder.click();
        return this;
    }

    public double getOrderSubTotalPrice(){
        return Double.parseDouble(cartSubTotalPrice.getText());
    }

    public double getOrderShippingPrice(){
        return Double.parseDouble(cartShippingPrice.getText());
    }

    public double getOrderPaymentMethodAdditionalFeePrice(){
        return Double.parseDouble(cartPaymentMethodAdditionalFeePrice.getText());
    }

    public double getOrderTaxPrice(){
        return Double.parseDouble(cartTaxPrice.getText());
    }
    public double getOrderTotalPrice(){
        return Double.parseDouble(cartTotalPrice.getText());
    }

    public CheckoutOrder verifyCartTotalOrder(){
        Assert.assertEquals(getOrderSubTotalPrice() + getOrderShippingPrice() + getOrderPaymentMethodAdditionalFeePrice()
        + getOrderTaxPrice(), getOrderTotalPrice());
        return this;
    }

}
