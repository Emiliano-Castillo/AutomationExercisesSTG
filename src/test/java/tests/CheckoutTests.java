package tests;

import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class CheckoutTests extends BaseTest {
    BasePage basePage;
    SignupLoginPage signupLoginPage;
    CartPage cartPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;

    @Test(priority = 1, enabled = true, description = "Test Place Order: Register while at checkout")
    public void registerWhileAtCheckout() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);

        basePage.verifyHomePage();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverSecondProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverThirdProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverForthProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverFifthProductClickAdd();
        cartPage.clickContinue();
        cartPage.clickCartBtn();
        cartPage.verifyCartPage();
        checkoutPage.proceedToCheckout();
        checkoutPage.clickRegister();
        signupLoginPage.sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyEnterAccountInformationIsVisible()
                .fillOutRegisterForm()
                .verifyAccountCreated()
                .clickContinueBtn()
                .verifyLoggedInAsUserName();
        cartPage.clickCartBtn();
        checkoutPage.proceedToCheckout()
                .verifyAddressDetailsAndReviewOrder()
                .reviewOrderItem1()
                .reviewOrderItem2()
                .reviewOrderItem3()
                .reviewOrderItem4()
                .reviewOrderItem5()
                .inputComment("Thanks for Automating This Site")
                .clickOnPlaceOrderBtn()
                .fillOutPaymentInfo()
                .clickContinue();
        signupLoginPage.clickDeleteBtn()
                .verifyAccountDeleted();
    }

    @Test(priority = 2, enabled = true, description = "Test Place Order: Register Before checkout")
    public void registerBeforeCheckout() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyEnterAccountInformationIsVisible()
                .fillOutRegisterForm()
                .verifyAccountCreated()
                .clickContinueBtn()
                .verifyLoggedInAsUserName();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverForthProductClickAdd();
        cartPage.clickCartBtn()
                .verifyCartPage();
        checkoutPage.proceedToCheckout()
                .verifyAddressDetailsAndReviewOrder()
                .reviewOrderItem1()
                .reviewOrderItem4()
                .inputComment("Thanks for the practice")
                .clickOnPlaceOrderBtn()
                .fillOutPaymentInfo()
                .clickContinue();
        signupLoginPage.clickDeleteBtn()
                .verifyAccountDeleted();
    }

    @Test(priority = 3, enabled = true, description = "Test Place Order: Login Before checkout")
    public void registerLoginBeforeCheckout() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyEnterAccountInformationIsVisible()
                .fillOutRegisterForm()
                .verifyAccountCreated()
                .clickContinueBtn()
                .logout()
                .clickSignupBtn()
                .loginWithCorrectCredentials()
                .verifyLoggedInAsUserName();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverThirdProductClickAdd();
        cartPage.clickCartBtn()
                .verifyCartPage();
        checkoutPage.proceedToCheckout()
                .verifyAddressDetailsAndReviewOrder()
                .reviewOrderItem1()
                .reviewOrderItem3()
                .inputComment("More Practice, Getting better")
                .clickOnPlaceOrderBtn()
                .fillOutPaymentInfo()
                .clickContinue();
        signupLoginPage.clickDeleteBtn()
                .verifyAccountDeleted();
    }

    @Test(priority = 4, enabled = true, description = "Test verify Address details in checkout page")
    public void verifyAddressDetailsInCheckout() {
        checkoutPage = new CheckoutPage(driver);
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyEnterAccountInformationIsVisible()
                .fillOutRegisterForm()
                .verifyAccountCreated()
                .clickContinueBtn()
                .verifyLoggedInAsUserName();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue()
                .clickCartBtn()
                .verifyCartPage();
        checkoutPage.proceedToCheckout()
                .verifyAddressDetailsAndReviewOrder();
        signupLoginPage.clickDeleteBtn()
                .verifyAccountDeleted();
    }

    @Test(priority = 5, enabled = true, description = "Test Download Invoice after Purchase order")
    public void downloadInvoiceAfterOrder() throws IOException {
        signupLoginPage = new SignupLoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        signupLoginPage.verifyHomePage();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverSecondProductClickAdd();
        cartPage.clickCartBtn()
                .verifyCartPage();
        checkoutPage.proceedToCheckout();
        checkoutPage.clickRegister();
        signupLoginPage.sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .fillOutRegisterForm()
                .verifyAccountCreated()
                .clickContinueBtn()
                .verifyLoggedInAsUserName();
        cartPage.clickCartBtn();
        checkoutPage.proceedToCheckout();
        checkoutPage.verifyAddressDetailsAndReviewOrder();
        checkoutPage.reviewOrderItem1()
                .reviewOrderItem2()
                .inputComment("kcisdcskc scsidljs dasjdv sdlkvj lsdvjsld vsjv sld v")
                .clickOnPlaceOrderBtn()
                .fillOutPaymentInfo()
                .verifyOrderPlaced()
                .clickDownload();
        checkoutPage.verifyDownloadIsSuccessful();
        signupLoginPage.clickDeleteBtn()
                .verifyAccountDeleted();
    }
}