package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestCasesPage extends BasePage {
    private final By clickOnTestCasesBtn = By.cssSelector(".fa-list");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    //TestCases Page Methods
    public TestCasesPage clickTestCases() {
        WebElement btnTestCase = wait.until(ExpectedConditions.elementToBeClickable(clickOnTestCasesBtn));
        actions.doubleClick(btnTestCase).perform();
        return this;
    }

    //Assertions
    public TestCasesPage verifyTestCasesPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases");
        return this;
    }
}
