package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContactPage extends BasePage {

    private final By clickOnContactUsBtn = By.cssSelector(".fa-envelope");
    private final By nameInput = By.cssSelector("[data-qa = 'name']");
    private final By emailInput = By.cssSelector("[data-qa= 'email']");
    private final By subjectInput = By.cssSelector("[data-qa= 'subject']");
    private final By messageInput = By.cssSelector("[data-qa= 'message']");
    private final By clickOnChooseFileBtn = By.cssSelector("input[type='file']");
    private final By clickOnSubmitBtn = By.cssSelector("input[type='submit']");
    private final By clickOnHomeBtn = By.cssSelector(".fa-home");
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    //ContactPage Methods
    public ContactPage clickContactBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnContactUsBtn)).click();
        return this;
    }

    public ContactPage sendKeysNameInput(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        return this;
    }

    public ContactPage sendKeysEmailInput(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        return this;
    }

    public ContactPage sendKeysSubjectInput(String subject) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput)).sendKeys(subject);
        return this;
    }

    public ContactPage sendKeysMessageInput(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput)).sendKeys(message);
        return this;
    }

    public ContactPage clickChooseFileBtn(String path) {
        driver.findElement(clickOnChooseFileBtn).sendKeys(path);
        return this;
    }

    public ContactPage clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSubmitBtn)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public ContactPage clickHomeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnHomeBtn)).click();
        return this;
    }

    //Assertions
    public ContactPage verifyGetInTouchIsVisible() {
        WebElement title = driver.findElement(By.xpath("//*[text() = 'Get In Touch']"));
        Assert.assertTrue(title.isDisplayed());
        return this;
    }

    public ContactPage verifySuccessMessage() {
        WebElement succMessage = driver.findElement(By.xpath("//*[text() = 'Success! Your details have been submitted successfully.']"));
        Assert.assertTrue(succMessage.isDisplayed());
        return this;
    }
}
