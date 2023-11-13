package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignupLoginPage extends BasePage{

    //Constructor
    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By clickOnLockIcon = By.cssSelector(".fa-lock");
    private final By nameInput = By.cssSelector("[data-qa='signup-name']");
    private final By emailInput = By.cssSelector("[data-qa='signup-email']");
    private final By clickOnSignupBtn = By.cssSelector("[data-qa='signup-button']");
    private final By selectGender = By.id("id_gender1");
    private final By formName = By.id("name");
    private final By formPassword = By.id("password");
    private final By formDays = By.id("days");
    private final By formDaySelect = By.cssSelector("#uniform-days [value ='22']");
    private final By formMonths = By.id("months");
    private final By formMonthSelect = By.cssSelector("#uniform-months [value = '6']");
    private final By formYear = By.id("years");
    private final By formYearSelect = By.cssSelector("#uniform-years [value ='1993']");
    private final By formCheckboxNewsletter = By.cssSelector("label[for='newsletter']");
    private final By formCheckboxSpecialOffers = By.id("optin");
    private final By formFirstName = By.cssSelector("[data-qa='first_name']");
    private final By formLastName = By.cssSelector("[data-qa='last_name']");
    private final By formCompanyName = By.cssSelector("[data-qa='company']");
    private final By formAddress = By.cssSelector("[data-qa='address']");
    private final By formAddress2 = By.cssSelector("[data-qa='address2']");
    private final By formCountryDropdown = By.cssSelector("[data-qa='country']");
    private final By formCountrySelect = By.cssSelector("#country [value='United States']");
    private final By formState = By.cssSelector("[data-qa='state']");
    private final By formCity = By.cssSelector("[data-qa='city']");
    private final By formZip = By.cssSelector("[data-qa='zipcode']");
    private final By formMobileNumber = By.cssSelector("[data-qa='mobile_number']");
    private final By formSubmit = By.cssSelector("[data-qa='create-account']");
    private final By formContinueBtn = By.cssSelector(".btn-primary");
    private final By clickOnDeleteBtn = By.cssSelector(".fa-trash-o");
//    private final By clickOnContinueBtn = By.ByCssSelector("");

    //Signup info methods
    public SignupLoginPage clickSignupBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnLockIcon)).click();
        return this;
    }
    public SignupLoginPage sendKeysNameInput (String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        return this;
    }
    public SignupLoginPage sendKeysEmailInput (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        return this;
    }
    public SignupLoginPage submitSignupBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSignupBtn)).click();
        return this;
    }

    //Signup form methods
    public SignupLoginPage genderSelect () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectGender)).click();
        return this;
    }
    public SignupLoginPage nameInput (String name) {
        WebElement nameValue = wait.until(ExpectedConditions.visibilityOfElementLocated(formName));
        nameValue.click();
        nameValue.clear();
        nameValue.sendKeys(name);
        return this;
    }
    public SignupLoginPage passwordInput (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formPassword)).sendKeys(password);
        return this;
    }
    public SignupLoginPage clickDayDropdown () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formDays)).click();
        return this;
    }
    public SignupLoginPage selectDay () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formDaySelect)).click();
        return this;
    }
    public SignupLoginPage clickMonthDropdown () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formMonths)).click();
        return this;
    }
    public SignupLoginPage selectMonth () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formMonthSelect)).click();
        return this;
    }
    public SignupLoginPage clickYearDropdown () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formYear)).click();
        return this;
    }
    public SignupLoginPage selectYear () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formYearSelect)).click();
        WebElement scrollDown = wait.until(ExpectedConditions.visibilityOfElementLocated(formCity));
        actions.moveToElement(scrollDown).perform();
        return this;
    }
    public SignupLoginPage checkboxSignupForOurNewsletter () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCheckboxNewsletter)).click();
        return this;
    }
    public SignupLoginPage checkboxSpecialOffers () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCheckboxSpecialOffers)).click();
        return this;
    }

    //Address Information
    public SignupLoginPage firstNameInput (String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formFirstName)).sendKeys(firstname);
        return this;
    }
    public SignupLoginPage lastNameInput (String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formLastName)).sendKeys(lastname);
        return this;
    }
    public SignupLoginPage companyNameInput (String company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCompanyName)).sendKeys(company);
        return this;
    }
    public SignupLoginPage addressNameInput (String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formAddress)).sendKeys(address);
        return this;
    }
    public SignupLoginPage address2NameInput (String address2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formAddress2)).sendKeys(address2);
        return this;
    }
    public SignupLoginPage countryDropdown () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCountryDropdown)).click();
        return this;
    }
    public SignupLoginPage selectCountry () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCountrySelect)).click();
        return this;
    }
    public SignupLoginPage stateNameInput (String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formState)).sendKeys(state);
        return this;
    }
    public SignupLoginPage cityNameInput (String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formCity)).sendKeys(city);
        return this;
    }
    public SignupLoginPage zipcodeInput (String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formZip)).sendKeys(zip);
        return this;
    }
    public SignupLoginPage mobileNumberInput (String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formMobileNumber)).sendKeys(number);
        return this;
    }
    public SignupLoginPage clickCreateBtn () {
        wait.until(ExpectedConditions.elementToBeClickable(formSubmit)).click();
        return this;
    }
    public SignupLoginPage clickContinueBtn () {
        wait.until(ExpectedConditions.elementToBeClickable(formContinueBtn)).click();
        return this;
    }
    //Login
    public SignupLoginPage loginWithCorrectCredentials () {
        enterEmail("emiliano.castillo@testpro.io");
        enterPassword("ABC123");
        clickLoginBtn();
        return this;
    }
    //Delete account
    public SignupLoginPage clickDeleteBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnDeleteBtn)).click();
        return this;
    }
//    public void clickContinueEnd () {
//        wait.until(ExpectedConditions.elementToBeClickable(clickOnContinueBtn)).click();
//    }

    //Assertions
    public SignupLoginPage verifyNewUserSignupIsVisible () {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        return this;
    }
    public SignupLoginPage verifyEnterAccountInformationIsVisible () {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Enter Account Information']")));
        Assert.assertTrue(title.isDisplayed());
        return this;
    }
    public SignupLoginPage verifyAccountCreated () {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
        return this;
    }
    public SignupLoginPage verifyLoggedInAsUserName () {
        WebElement userLoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = ' Logged in as ']")));
        Assert.assertTrue(userLoggedIn.isDisplayed());
        return this;
    }
    public SignupLoginPage verifyAccountDeleted () {
        WebElement accountDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Account Deleted!']")));
        Assert.assertTrue(accountDeleted.isDisplayed());
        return this;
    }
}