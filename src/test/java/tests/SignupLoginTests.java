package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.SignupLoginPage;

public class SignupLoginTests extends BaseTest{

    BasePage basePage;
    SignupLoginPage signupLoginPage;

    @Test(priority = -6, enabled = true, description = "Test registration of a new user")
    public void registerUser () {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                       .verifyNewUserSignupIsVisible()
                       .sendKeysNameInput("Emiliano")
                       .sendKeysEmailInput("emiliano.castillo@testpro.io")
                       .submitSignupBtn()
                       .verifyEnterAccountInformationIsVisible()
                .fillOutRegisterForm()
                       .verifyAccountCreated()
                       .clickContinueBtn()
                .verifyLoggedInAsUserName();
//                .clickDeleteBtn()
//                .verifyAccountDeleted();
    }

    @Test(priority = -5, enabled = true, description = "Test Login Successfully")
    public void loginWithCorrectEmailAndPassword() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .verifyNewUserSignupIsVisible()
                .clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithCorrectCredentials()
                .verifyLoggedInAsUserName();
//                     .clickDeleteBtn()
//                     .verifyAccountDeleted();
    }

    @Test(priority = -4, enabled = true, description = "Test Incorrect Login Error")
    public void loginWithIncorrectEmailAndPassword() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithIncorrectCredentials()
                .verifyIncorrectEmailAndPasswordError();
    }

    @Test(priority = -3, enabled = true, description = "Test Logout Successfully")
    public void logoutSuccessful() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .verifyLoginToYourAccount()
                .loginWithCorrectCredentials()
                .verifyLoggedInAsUserName()
                .logout()
                .verifyNewUserSignupIsVisible();
    }

    @Test(priority = -2, enabled = true, description = "Test registration of user with existing email Error")
    public void registerUserWithExistingEmail() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        basePage.verifyHomePage();
        signupLoginPage.clickSignupBtn()
                .verifyNewUserSignupIsVisible()
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyErrorEmailAddressAlreadyExist();
    }

    @Test(priority = -1, enabled = true, description = "Simple test to login and delete account so everytime PageObject runs, it ensures all test will pass consistently")
    public void loginDel() {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.signinAndDeleteAccount();
    }
}