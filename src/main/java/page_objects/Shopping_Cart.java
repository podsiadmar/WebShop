package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Shopping_Cart extends Base{
    public Shopping_Cart(WebDriver driver) { super(driver); }

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

    public Shopping_Cart verifySubTotalPrice(){
        String unitPrice = firstProductUnitPrice.getText();
        String quantity = firstProductQuantity.getAttribute("Value");
        String subTotal = subTotalPrice.getText();
        Double countedSubTotalPrice = Double.valueOf(subTotal);
        Double subTotalPrice = Double.valueOf(unitPrice) * Double.valueOf(quantity);
        Assert.assertTrue(subTotalPrice.equals(countedSubTotalPrice));
        return this;
    }

    public Shopping_Cart startCheckout(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(termOfServiceCheckbox.isDisplayed());
        Assert.assertTrue(checkoutButton.isDisplayed());
        termOfServiceCheckbox.click();
        checkoutButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Checkout']")).isDisplayed());
        return this;
    }

    public Shopping_Cart verifyShoppingCartIsEmpty(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean isProductInCartVisible = isElementPresent(By.xpath("//tr[@class='cart-item-row'][1]"));
        Assert.assertTrue(isProductInCartVisible==false);
        return this;
    }

    public Shopping_Cart removeFirstProduct(){
        Assert.assertTrue(removeFromCartFirstCheckbox.isDisplayed());
        Assert.assertTrue(updateShoppingCartButton.isDisplayed());
        removeFromCartFirstCheckbox.click();
        updateShoppingCartButton.click();
        return this;
    }
}
