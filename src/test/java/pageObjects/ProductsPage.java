package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    private final By clickOnProductsBtn = By.cssSelector(".card_travel");
    private final By clickOnViewProductsBtn = By.cssSelector("a[href='/product_details/1']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Product Page Methods
    public ProductsPage clickProductsBtn() {
        WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnProductsBtn));
        actions.moveToElement(products).doubleClick().perform();
        return this;
    }

    public ProductsPage clickViewProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnViewProductsBtn)).click();
        return this;
    }

    //Assertions
    public ProductsPage verifyProductsPage() {
        WebElement titleAllProduts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'All Products']")));
        Assert.assertTrue(titleAllProduts.isDisplayed());
//        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
        return this;
    }

    public ProductsPage verifyFirstProductIsVisible() {
//        WebElement titleBlue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Blue Top']")));
////        Assert.assertTrue(titleBlue.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
        return this;
    }

    public ProductsPage verifyProductDetails() {
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Blue Top']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Category: Women > Tops']")));
        Assert.assertTrue(category.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='product-information'] span span")));
        Assert.assertTrue(price.isDisplayed());

        WebElement availability = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Availability:']")));
        Assert.assertTrue(availability.isDisplayed());

        WebElement condition = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Condition:']")));
        Assert.assertTrue(condition.isDisplayed());

        WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Brand:']")));
        Assert.assertTrue(brand.isDisplayed());
        return this;
    }
}