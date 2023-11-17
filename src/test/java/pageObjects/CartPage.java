package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By cartBtn = By.cssSelector(".fa.fa-shopping-cart");
    private final By clickContinueShopping = By.cssSelector(".btn.btn-success.close-modal");
    private final By clickViewCartBtn = By.xpath("//*[text()='View Cart']");
    private final By moveToBlueTop = By.xpath("//*[text() = 'Blue Top']");
    private final By moveToTshirt = By.xpath("//*[text() = 'Men Tshirt']");
    private final By firstItemsInCart = By.cssSelector("#product-1 .cart_price");
    private final By cartquantity = By.cssSelector("#product-1 .disabled");
    private final By totalPriceItem = By.cssSelector("#product-1 .cart_total_price");
    private final By viewBtnStylishDress = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(6) > div > div.choose > ul > li > a");
    private final By inputQ = By.cssSelector("#quantity");
    private final By addToCartBtn = By.cssSelector("button[type='button']");

    public CartPage clickCartBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBtn)).click();
        return this;
    }
    public CartPage clickContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickContinueShopping)).click();
        return this;
    }
    public CartPage clickViewCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickViewCartBtn)).click();
        return this;
    }

    public CartPage clickStylishDressViewProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewBtnStylishDress)).click();
        return this;
    }

    public CartPage inputQuantity(String number) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputQ));
        input.click();
        input.clear();
        input.sendKeys(String.valueOf(number));
//        input.sendKeys(Keys.chord(Keys.TAB, Keys.ENTER));

        return this;
    }

    public CartPage addToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
        return this;
    }

    //Assertion
    public CartPage verifyCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        return this;
    }

    public CartPage verifyItemsInCart() {
        WebElement blueTop = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToBlueTop));
        Assert.assertTrue(blueTop.isDisplayed());

        WebElement menTshirt = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToTshirt));
        Assert.assertTrue(menTshirt.isDisplayed());
        return this;
    }

    public CartPage verifyItemsDetails() {
        WebElement prices = wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemsInCart));
        Assert.assertTrue(prices.isDisplayed());

        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(cartquantity));
        Assert.assertTrue(quantity.isDisplayed());

        WebElement totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceItem));
        Assert.assertTrue(totalPrice.isDisplayed());
        return this;
    }

    public CartPage verifyItemQuantity() {
        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-4 .disabled")).getText());
        Assert.assertTrue(quantity == 4);
        return this;
    }
}