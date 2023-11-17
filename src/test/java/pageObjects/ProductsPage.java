package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By clickOnViewProductsBtn = By.cssSelector("a[href='/product_details/1']");
    private final By searchInputField = By.cssSelector("input[type='text']");
    private final By clickOnMagnifyingGlass = By.cssSelector("button[type='button']");
    private final By clickOnProductsBtn = By.cssSelector(".card_travel");


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

    public ProductsPage searchFieldInput(String productName) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputField));
        search.clear();
        search.sendKeys(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnMagnifyingGlass)).click();
        return this;
    }

    private final By moveToBlueTop = By.xpath("//*[text() = 'Blue Top']");
    private final By moveToTshirt = By.xpath("//*[text() = 'Men Tshirt']");
    private final By clickAddPOneBtn = By.cssSelector(".product-overlay a[data-product-id='1'].add-to-cart");
    private final By clickAddPTwoBtn = By.cssSelector(".product-overlay a[data-product-id='2'].add-to-cart");

    public ProductsPage hoverOverProductClickAdd() {
        WebElement moveToBlueTopEl = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToBlueTop));
        actions.moveToElement(moveToBlueTopEl).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(clickAddPOneBtn)).click();
        return this;
    }

    public ProductsPage hoverOverSecondProductClickAdd() {
        WebElement moveToBlueTopEl = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToTshirt));
        actions.moveToElement(moveToBlueTopEl).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(clickAddPTwoBtn)).click();
        return this;
    }

    //Assertions
    public ProductsPage verifyProductsPage() {
        WebElement titleAllProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'All Products']")));
        Assert.assertTrue(titleAllProducts.isDisplayed());
        return this;
    }

    public ProductsPage verifyFirstProductIsVisible() {
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

    public ProductsPage verifySearchedProductIsVisible() {
        WebElement specificProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Searched Products']")));
        Assert.assertTrue(specificProduct.isDisplayed());
        return this;
    }

    public ProductsPage verifyAllProductsForJeansSearchAreVisible() {
        WebElement softStretchJeans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Soft Stretch Jeans']")));
        Assert.assertTrue(softStretchJeans.isDisplayed());

        WebElement regularFitStraightJeans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Regular Fit Straight Jeans']")));
        Assert.assertTrue(regularFitStraightJeans.isDisplayed());

        WebElement gruntBlueSlimFitJeans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Grunt Blue Slim Fit Jeans']")));
        Assert.assertTrue(gruntBlueSlimFitJeans.isDisplayed());
        return this;
    }
}