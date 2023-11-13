package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignupLoginPage extends BasePage{

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By clickOnLockIcon = By.cssSelector(".fa-lock");
    private final By nameInput = By.cssSelector("[data-qa='signup-name']");
    private final By emailInput = By.cssSelector("[data-qa='signup-email']");
    private final By clickOnSignupBtn = By.cssSelector("[data-qa='signup-button']");


    public SignupLoginPage clickSignupBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnLockIcon)).click();
        return this;
    }

    public SignupLoginPage sendKeysNameInput () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys("Emiliano");
        return this;
    }

    public SignupLoginPage sendKeysEmailInput () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys("emiliano.castillo@testpro.io");
        return this;
    }

    public void submitSignupBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSignupBtn)).click();
    }

    //Assertions
    public SignupLoginPage verifyNewUserSignupIsVisible () {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        return this;
    }

}