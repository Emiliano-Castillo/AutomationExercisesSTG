package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {
    private final By cartBtn = By.cssSelector(".fa.fa-shopping-cart");
    private final By clickContinueShopping = By.cssSelector(".btn.btn-success.close-modal");
    private final By clickViewCartBtn = By.xpath("//*[text()='View Cart']");
    private final By moveToBlueTop = By.xpath("//*[text() = 'Blue Top']");
    private final By moveToTshirt = By.xpath("//*[text() = 'Men Tshirt']");
    private final By firstItemsInCart = By.cssSelector("#product-1 .cart_price");
    private final By cartquantity = By.cssSelector("#product-1 .disabled");
    private final By totalPriceItem = By.cssSelector("#product-1 .cart_total_price");
    public CartPage(WebDriver driver) {
        super(driver);
    }

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
}