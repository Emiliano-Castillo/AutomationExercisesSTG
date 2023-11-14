package tests;

import org.testng.annotations.Test;
import pageObjects.SignupLoginPage;

public class SignupLoginTests extends BaseTest{

    SignupLoginPage signupLoginPage;

    @Test(priority = 1, enabled = true)
    public void registerUser () {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.verifyHomePage()
                .clickSignupBtn()
                       .verifyNewUserSignupIsVisible()
                //Register with name and email
                       .sendKeysNameInput("Emiliano")
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
//                //Login
//                       .clickSignupBtn()
//                       .loginWithCorrectCredentials()
//                //Delete account
//                        .clickDeleteBtn()
//                        .verifyAccountDeleted()
//                        .clickContinueBtn();
    }

    @Test(priority = 2, enabled = true)
    public void loginWithCorrectEmailAndPassword() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.verifyHomePage()
                .clickSignupBtn()
                .verifyNewUserSignupIsVisible()
                .clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithCorrectCredentials()
                .verifyLoggedInAsUserName();
//                     .clickDeleteBtn()
//                     .verifyAccountDeleted();
    }

    @Test(priority = 3, enabled = true)
    public void loginWithIncorrectEmailAndPassword() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.verifyHomePage()
                .clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithIncorrectCredentials()
                .verifyIncorrectEmailAndPasswordError();
    }

    @Test(priority = 4, enabled = true)
    public void logoutSuccessful() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.verifyHomePage()
                .clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithCorrectCredentials()
                .verifyLoggedInAsUserName()
                .logout()
                .verifyNewUserSignupIsVisible();
    }

    @Test(priority = 5, enabled = true)
    public void registerUserWithExistingEmail() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.verifyHomePage()
                .clickSignupBtn()
                .verifyNewUserSignupIsVisible()
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyErrorEmailAddressAlreadyExist();
    }

    @Test(priority = 6, enabled = true)
    public void loginDel() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.signinAndDeleteAccount();
    }
}