package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.rmi.log.LogInputStream;

public class Products extends Base {
    @FindBy(xpath = "//li[@class='next-page']/a")
    private WebElement nextButton;
    @FindBy(xpath = "//input[contains(@name, 'addtocart_')]")
    private WebElement quantityInput;
    @FindBy(xpath = "//select[contains(@id, 'product_attribute_')]")
    private WebElement sizeList;
    @FindBy(xpath = "//input[contains(@id, 'add-to-cart-button')]")
    private WebElement addToCartButton;

    public Products(WebDriver driver) {super(driver);}

    //this method finds the product on the list, if it not exist, it will click next button
    public Products selectProduct(String productName){

        do{
            boolean isProductVisible = isElementPresent(By.xpath("//a[contains(text(), '"+productName+"')]"));
            if (isProductVisible==false){nextButton.click();}
        }
        while (isElementPresent(By.linkText("Next"))==true);
        boolean isProductVisible = isElementPresent(By.xpath("//a[contains(text(), '"+productName+"')]"));
        if (isProductVisible==false){
            try { driver.findElement(By.xpath("//a[contains(text(), '"+productName+"')]")).click(); }
            catch (NoSuchElementException e) { System.out.println("This product is not available in this category"); }
        }
        driver.findElement(By.xpath("//a[contains(text(), '"+productName+"')]")).click();
       return this;
    }

    public Products addQuantity(Integer howMuch){
        String strHowMuch = howMuch.toString();
        Assert.assertTrue(quantityInput.isDisplayed());
        quantityInput.clear();
        quantityInput.sendKeys(strHowMuch);
        return this;
    }

    public Products selectSize(String sizeName){
        Assert.assertTrue(sizeList.isDisplayed());
        Select drpSize = new Select(sizeList);

        if(sizeName=="Large"){ drpSize.selectByValue("34"); }
        else if(sizeName=="Small"){ drpSize.selectByValue("32"); }
        else if(sizeName=="Medium"){ drpSize.selectByValue("33"); }
        else if(sizeName=="X-Large"){ drpSize.selectByValue("35"); }
        return  this;
    }

    public Products clickAddToCart(){
        Assert.assertTrue(addToCartButton.isDisplayed());
        addToCartButton.click();
        return this;
    }

}
