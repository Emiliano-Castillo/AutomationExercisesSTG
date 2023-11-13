package tests;

import org.testng.annotations.Test;
import pageObjects.SignupLoginPage;

public class SignupLoginTests extends BaseTest{

    SignupLoginPage signupLoginPage;

    @Test
    public void registerUser () {
        signupLoginPage = new SignupLoginPage(driver);

        signupLoginPage.clickSignupBtn()
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
                       .verifyLoggedInAsUserName()
                //Login
                       .clickSignupBtn()
                       .loginWithCorrectCredentials()
                //Delete account
                        .clickDeleteBtn()
                        .verifyAccountDeleted()
                        .clickContinueBtn();
    }
}