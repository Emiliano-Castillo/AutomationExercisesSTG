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
                       .sendKeysNameInput()
                       .sendKeysEmailInput()
                       .submitSignupBtn();
    }
}
