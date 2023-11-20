package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    private final By emailInput = By.cssSelector("[data-qa='login-email']");
    private final By passwordInput = By.cssSelector("[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("[data-qa='login-button']");

    //Helper Methods
    public void enterEmail (String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }
    public void enterPassword (String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }
    public void clickLoginBtn (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }

    private final By recommendedItems = By.cssSelector(".recommended_items .title");
    private final By clickAddCart = By.cssSelector("#recommended-item-carousel [data-product-id='5']");
    private final By clickView = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2)");

    public BasePage scrollDown() {
        WebElement rItems = wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedItems));
        actions.scrollToElement(rItems).perform();
        return this;
    }

    public BasePage clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickAddCart)).click();
        return this;
    }

    public BasePage clickViewCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickView)).click();
        return this;
    }

    //Helper Assertions
    public BasePage verifyHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }

    public BasePage verifyRecommendedItemsAreVisible() {
        WebElement items = wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedItems));
        Assert.assertTrue(items.isDisplayed());
        return this;
    }

}