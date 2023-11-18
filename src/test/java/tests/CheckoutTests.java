package tests;

import org.testng.annotations.Test;
import pageObjects.*;

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
                //Fill out form
                .genderSelect()
                .nameInput("Emiliano")
                .passwordInput("ABC123")
                .clickDayDropdown()
                .selectDay()
                .clickMonthDropdown()
                .selectMonth()
                .clickYearDropdown()
                .selectYear()
                .checkboxSignupForOurNewsletter()
                .checkboxSpecialOffers()
                .firstNameInput("Emiliano")
                .lastNameInput("Castillo")
                .companyNameInput("eacwebdev")
                .addressNameInput("4109 E tenth ave")
                .address2NameInput("Milo")
                .countryDropdown()
                .selectCountry()
                .stateNameInput("Colorado")
                .cityNameInput("Denver")
                .zipcodeInput("80220")
                .mobileNumberInput("777 777 7777")
                .clickCreateBtn()
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
                .enterNameOnCard("Emi")
                .enterCCNumber("0000-0000-0000-0001")
                .inputCvcNumber("777")
                .inputExMonth("07")
                .inputExYear("2037")
                .clickonPayBtn()
                .verifyOrderPlaced()
                .clickContinue()
                .clickOnDelete();
    }
}