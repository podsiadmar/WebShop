package pageObjects;

import jline.internal.Log;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Products extends Base {
    static Integer productsAmount;
    static String alphabet = "0123456789abcdefghijklmnopqrstuwxyz";

    @FindBy(css = ".product-item h2 a")
    private List<WebElement> products;
    @FindBy(css = "li[class=next-page] a")
    private WebElement nextButton;
    @FindBy(xpath = "//input[contains(@name, 'addtocart_')]")
    private WebElement quantityInput;
    @FindBy(xpath = "//select[contains(@id, 'product_attribute_')]")
    private WebElement sizeList;
    @FindBy(xpath = "//input[contains(@id, 'add-to-cart-button')]")
    private WebElement addToCartButton;
    @FindBy(css = "#products-orderby")
    private WebElement sortByList;
    @FindBy(css = "#products-pagesize")
    private WebElement displayPerPageList;
    @FindBy(css = ".item-box")
    private List<WebElement> productsOnGrid;
    @FindBy(css = ".price")
    private List<WebElement> visiblePrices;
    @FindBy(css = ".product-title a")
    private List<WebElement> visibleProductTitles;

    //this method finds the product on the list, if it not exist, it will click next button
    public Products selectProduct(String productName){
        List<WebElement> lookedUpProduct;
        do {
             lookedUpProduct = this.products
                    .stream()
                    .filter(element -> element.getText().contains(productName))
                    .collect(Collectors.toList());
             if(lookedUpProduct.isEmpty() && nextButton.isDisplayed())
                 nextButton.click();
             else if(lookedUpProduct.isEmpty() && !nextButton.isDisplayed())
                 throw new InvalidArgumentException("There is n such product in catalog.");
        } while (lookedUpProduct.isEmpty());

        lookedUpProduct.get(0).click();
       return this;
    }

    public Products addQuantity(int howMuch) {
        quantityInput.clear();
        quantityInput.sendKeys(howMuch+"");
        return this;
    }

    public Products selectSize(String sizeName) {
        Select drpSize = new Select(sizeList);
        switch (sizeName){
            case "Large":
                drpSize.selectByValue("34");
                break;
            case "Small":
                drpSize.selectByValue("32");
                break;
            case "Medium":
                drpSize.selectByValue("33");
                break;
            case "X-Large":
                drpSize.selectByValue("35");
                break;
            default:
                throw new InvalidArgumentException("Invalid size.");
        }

        return  this;
    }

    public Products selectDisplayPerPageAmount(Integer amountPerPage){
        Select drpAmountPerPage = new Select(displayPerPageList);
        drpAmountPerPage.selectByVisibleText(amountPerPage.toString());
        softAssertion.assertEquals(drpAmountPerPage.getFirstSelectedOption().getText(), amountPerPage.toString());
        softAssertion.assertAll();
    return this;
    }

    public Products selectProductSort(String sortBy){
        Select drpSortBy = new Select(sortByList);
        drpSortBy.selectByVisibleText(sortBy);
        softAssertion.assertEquals(drpSortBy.getFirstSelectedOption().getText(), sortBy);
        softAssertion.assertAll();
        return this;
    }

    public Integer getCountOfVisibleProducts(){
        List<WebElement> products = productsOnGrid;
        return products.size();
    }

    public void verifyProductAmmount(Integer expectedProductAcmount){
        Assert.assertEquals(expectedProductAcmount, getCountOfVisibleProducts());
    }

    public void verifyPriceSortingLowToHigh(){
        List<WebElement> productPrices = visiblePrices;
        do {
            for(int i=0; i<productPrices.size()-1; i++){
                softAssertion.assertTrue(Double.parseDouble(visiblePrices.get(i).getText())<=Double.parseDouble(visiblePrices.get(i+1).getText()));
            }
            try {
                turnOffImplicitWaits();
                nextButton.isDisplayed();
                nextButton.click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                turnOnImplicitWaits();
                break;
            }
        }
        while (productPrices.size()>0);
        softAssertion.assertAll();
    }

    public void verifyPriceSortingHighToLow(){
        List<WebElement> productPrices = visiblePrices;
        do {
            for(int i=0; i<productPrices.size()-1; i++){
                softAssertion.assertTrue(Double.parseDouble(visiblePrices.get(i).getText())>=Double.parseDouble(visiblePrices.get(i+1).getText()));
            }
            try {
                turnOffImplicitWaits();
                nextButton.isDisplayed();
                nextButton.click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                turnOnImplicitWaits();
                break;
            }
        }
        while (productPrices.size()>0);
        softAssertion.assertAll();
    }

    public void verifyProductAlphabeticalSort(){
        List<WebElement> productTitle = visibleProductTitles;
        char first = productTitle.get(0).toString().charAt(0);
    }



    public void clickAddToCart(){
        addToCartButton.click();
    }

}
