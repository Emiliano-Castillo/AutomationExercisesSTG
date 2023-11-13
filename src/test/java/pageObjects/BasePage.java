package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}