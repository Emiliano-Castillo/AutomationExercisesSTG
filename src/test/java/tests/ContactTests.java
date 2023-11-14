package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.ContactPage;
import pageObjects.SignupLoginPage;

public class ContactTests extends BaseTest {

    BasePage basePage;
    SignupLoginPage signupLoginPage;
    ContactPage contactPage;

    @Test
    public void contactUsForm() {
        basePage = new BasePage(driver);
        signupLoginPage = new SignupLoginPage(driver);
        contactPage = new ContactPage(driver);

        basePage.verifyHomePage();
        contactPage.clickContactBtn()
                .verifyGetInTouchIsVisible()
                .sendKeysNameInput("Emi")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .sendKeysSubjectInput("HelloWorld!!!!!!!")
                .sendKeysMessageInput("Thanks for the Automation Practice WebSite!")
                .clickChooseFileBtn("/Users/emiliano/Documents/Agile vs Waterfall.png")
                .clickSubmitBtn()
                .verifySuccessMessage()
                .clickHomeBtn();
        basePage.verifyHomePage();
    }
}