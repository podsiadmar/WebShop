package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ShoppingCart extends Base {

    @FindBy(css = ":first-of-type .product-unit-price")
    private WebElement firstProductUnitPrice;
    @FindBy(css = ":first-of-type .qty-input")
    private WebElement firstProductQuantity;
    @FindBy(name = "termsofservice")
    private WebElement termOfServiceCheckbox;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(css = " .cart-total tr:first-child .product-price")
    private WebElement subTotalPrice;
    @FindBy(css = ":first-of-type.cart-item-row [name=removefromcart]")
    private WebElement removeFromCartFirstCheckbox;
    @FindBy(name = "updatecart")
    private WebElement updateShoppingCartButton;
    @FindBy(css = ":first-of-type.cart-item-row")
    private WebElement firstCartItemRow;
    @FindBy(className = "cart-item-row")
    private List<WebElement> cartItems;

    public CheckoutOrder startCheckout(){
        termOfServiceCheckbox.click();
        checkoutButton.click();
        return new CheckoutOrder();
    }

    public ShoppingCart removeFirstProduct(){
        removeFromCartFirstCheckbox.click();
        updateShoppingCartButton.click();
        return this;
    }

    public ShoppingCart verifySubTotalPrice(){
        Assert.assertEquals(Double.parseDouble(firstProductUnitPrice.getText())
                * Double.parseDouble(firstProductQuantity.getAttribute("Value")),
                Double.parseDouble(subTotalPrice.getText()));
        return this;
    }

    public ShoppingCart verifyShoppingCartIsEmpty(){
        turnOffImplicitWaits();
        Assert.assertTrue(cartItems.isEmpty());
        turnOnImplicitWaits();
        return this;
    }
}
