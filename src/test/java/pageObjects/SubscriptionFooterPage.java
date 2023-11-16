package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SubscriptionFooterPage extends BasePage {

    private final By subscriptionText = By.xpath("//*[text()='Subscription']");
    private final By emailInput = By.cssSelector("input[type='email']");
    private final By clickOnSubmitBtn = By.cssSelector("button[type='submit']");
    private final By successMessage = By.xpath("//*[text()='You have been successfully subscribed!']");
    public SubscriptionFooterPage(WebDriver driver) {
        super(driver);
    }

    //Subscriptions Methods
    public SubscriptionFooterPage enterEmailSubField(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement clickSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSubmitBtn));
        clickSubmit.click();
        return this;
    }

    //Assertions
    public SubscriptionFooterPage verifyTextSubscription() {
        WebElement subText = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
        Assert.assertTrue(subText.isDisplayed());
        return this;
    }

    public SubscriptionFooterPage verifySuccessMessage() {
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertTrue(success.isDisplayed());
        return this;
    }
}