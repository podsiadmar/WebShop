package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ShoppingCart extends Base {

    @FindBy(xpath = "//span[@class='product-unit-price'][1]")
    private WebElement firstProductUnitPrice;
    @FindBy(xpath = "//input[contains(@name, 'itemquantity')][1]")
    private WebElement firstProductQuantity;
    @FindBy(name = "termsofservice")
    private WebElement termOfServiceCheckbox;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[text()='Sub-Total:']/ancestor::td/following-sibling::td//span[@class='product-price']")
    private WebElement subTotalPrice;
    @FindBy(xpath = "//tr[@class='cart-item-row'][1]/td/input")
    private WebElement removeFromCartFirstCheckbox;
    @FindBy(name = "updatecart")
    private WebElement updateShoppingCartButton;
    @FindBy(xpath = "//tr[@class='cart-item-row'][1]")
    private WebElement firstCartItemRow;
    @FindBy(className = "cart-item-row")
    private List<WebElement> cartItems;

    public ShoppingCart verifySubTotalPrice(){
        double unitPrice = Double.parseDouble(firstProductUnitPrice.getText());
        double quantity = Double.parseDouble(firstProductQuantity.getAttribute("Value"));
        double subTotal = Double.parseDouble(subTotalPrice.getText());
        Assert.assertEquals(unitPrice * quantity, subTotal);
        return this;
    }

    public ShoppingCart startCheckout(){
        termOfServiceCheckbox.click();
        checkoutButton.click();
        return this;
    }

    public ShoppingCart verifyShoppingCartIsEmpty(){
        Assert.assertTrue(cartItems.isEmpty());
        return this;
    }

    public ShoppingCart removeFirstProduct(){
        removeFromCartFirstCheckbox.click();
        updateShoppingCartButton.click();
        return this;
    }
}
