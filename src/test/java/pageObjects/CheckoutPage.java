package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.VerifyDownload;

import java.io.IOException;

public class CheckoutPage extends BasePage {
    private final By clickDeleteBtn = By.cssSelector(".fa-trash-o");
    private final By clickOnContinue = By.cssSelector("[data-qa='continue-button']");
    private final By clickRegister_LoginBtn = By.xpath("//*[text() = 'Register / Login']");
    private final By clickProceedToCheckoutBtn = By.cssSelector(".btn-default.check_out");
    private final By comment = By.cssSelector(".form-control");
    private final By clickPO = By.cssSelector(".btn-default.check_out");
    private final By inputCCName = By.cssSelector("input[name='name_on_card']");
    private final By inputCC = By.cssSelector("input[name='card_number']");
    private final By inputCvc = By.cssSelector("input[name='cvc']");
    private final By inputMonth = By.cssSelector("input[name='expiry_month']");
    private final By inputYear = By.cssSelector("input[name='expiry_year']");
    private final By clickPayBtn = By.cssSelector("button[data-qa='pay-button']");
    private final By titleAddress = By.xpath("//*[text() = 'Address Details']");
    private final By firstN = By.cssSelector("#address_delivery > li.address_firstname.address_lastname");
    private final By reviewTitle = By.xpath("//*[text() = 'Review Your Order']");
    private final By clickDownloadBtn = By.cssSelector(".btn-default.check_out");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickProceedToCheckoutBtn)).click();
        return this;
    }

    public CheckoutPage clickRegister() {
        WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(clickRegister_LoginBtn));
        actions.click(register).perform();
        return this;
    }

    public CheckoutPage inputComment(String comments) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(comment)).sendKeys(comments);
        return this;
    }

    public CheckoutPage clickOnPlaceOrderBtn() {
        actions.scrollByAmount(0, 500).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickPO)).click();
        return this;
    }

    public CheckoutPage enterNameOnCard(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCCName)).sendKeys(name);
        return this;
    }

    public CheckoutPage enterCCNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCC)).sendKeys(number);
        return this;
    }

    public CheckoutPage inputCvcNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCvc)).sendKeys(number);
        return this;
    }

    public CheckoutPage inputExMonth(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMonth)).sendKeys(number);
        return this;
    }

    public CheckoutPage inputExYear(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputYear)).sendKeys(number);
        return this;
    }
    public CheckoutPage clickonPayBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickPayBtn)).click();
        return this;
    }

    public CheckoutPage clickContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnContinue)).click();
        return this;
    }

    public CheckoutPage clickDownload() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickDownloadBtn)).click();
        return this;
    }

    //Fill out payment information
    public CheckoutPage fillOutPaymentInfo() {
        enterNameOnCard("Emi");
        enterCCNumber("0000-0000-0000-0001");
        inputCvcNumber("777");
        inputExMonth("07");
        inputExYear("2037");
        clickonPayBtn();
        verifyOrderPlaced();
        return this;
    }

    //Assertions
    public CheckoutPage verifyAddressDetailsAndReviewOrder() {

        WebElement addressD = wait.until(ExpectedConditions.visibilityOfElementLocated(titleAddress));
        Assert.assertTrue(addressD.isDisplayed());

        String firstName = driver.findElement((firstN)).getText();
        Assert.assertTrue(firstName.equals("Mr. Emiliano Castillo"));

        String company = driver.findElement(By.cssSelector("#address_delivery > li:nth-child(3)")).getText();
        Assert.assertTrue(company.equals("eacwebdev"));

        String address = driver.findElement(By.cssSelector("#address_delivery > li:nth-child(4)")).getText();
        Assert.assertTrue(address.equals("4109 E tenth ave"));

        String address2 = driver.findElement(By.cssSelector("#address_delivery > li:nth-child(5)")).getText();
        Assert.assertTrue(address2.equals("Milo"));

        String cityStateZip = driver.findElement(By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode")).getText();
        Assert.assertTrue(cityStateZip.equals("Denver Colorado 80220"));

        String country = driver.findElement(By.cssSelector("#address_delivery > li.address_country_name")).getText();
        Assert.assertTrue(country.equals("United States"));

        String pNumber = driver.findElement(By.cssSelector("#address_delivery > li.address_phone")).getText();
        Assert.assertTrue(pNumber.equals("777 777 7777"));
        return this;
    }
    public CheckoutPage reviewOrderItem1() {
        WebElement reviewO = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTitle));
        Assert.assertTrue(reviewO.isDisplayed());

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Blue Top']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-1 > td.cart_price")));
        Assert.assertTrue(price.isDisplayed());

        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-1 .disabled")).getText());
        Assert.assertTrue(quantity == 1);

        WebElement totalItemP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-1 .cart_total_price")));
        Assert.assertTrue(totalItemP.isDisplayed());

        return this;
    }
    public CheckoutPage reviewOrderItem2() {

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Men Tshirt']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-2 > td.cart_price")));
        Assert.assertTrue(price.isDisplayed());

        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-2 .disabled")).getText());
        Assert.assertTrue(quantity == 1);

        WebElement totalItemP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-2 .cart_total_price")));
        Assert.assertTrue(totalItemP.isDisplayed());

        return this;
    }
    public CheckoutPage reviewOrderItem3() {

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Sleeveless Dress']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-3 > td.cart_price")));
        Assert.assertTrue(price.isDisplayed());

        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-3 .disabled")).getText());
        Assert.assertTrue(quantity == 1);

        WebElement totalItemP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-3 .cart_total_price")));
        Assert.assertTrue(totalItemP.isDisplayed());

        return this;
    }
    public CheckoutPage reviewOrderItem4() {

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Stylish Dress']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-4 > td.cart_price")));
        Assert.assertTrue(price.isDisplayed());

        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-4 .disabled")).getText());
        Assert.assertTrue(quantity == 1);

        WebElement totalItemP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-4 .cart_total_price")));
        Assert.assertTrue(totalItemP.isDisplayed());

        return this;
    }
    public CheckoutPage reviewOrderItem5() {

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Winter Top']")));
        Assert.assertTrue(name.isDisplayed());

        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-5 > td.cart_price")));
        Assert.assertTrue(price.isDisplayed());

        int quantity = Integer.parseInt(driver.findElement(By.cssSelector("#product-5 .disabled")).getText());
        Assert.assertTrue(quantity == 1);

        WebElement totalItemP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-5 .cart_total_price")));
        Assert.assertTrue(totalItemP.isDisplayed());

        return this;
    }
    public CheckoutPage verifyOrderPlaced() {
        WebElement orderPlaced = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Order Placed!']")));
        Assert.assertTrue(orderPlaced.isDisplayed());

        WebElement congratulations = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")));
        Assert.assertTrue(congratulations.isDisplayed());
        return this;
    }

    public CheckoutPage verifyDownloadIsSuccessful() throws IOException {
        boolean isFileDownloaded = VerifyDownload.isFileDownloaded("invoice", "txt", 5000);
        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
        return this;
    }
}
