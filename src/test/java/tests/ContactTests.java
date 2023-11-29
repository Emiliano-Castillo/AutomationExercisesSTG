//package tests;
//
//import org.testng.annotations.Test;
//import pageObjects.BasePage;
//import pageObjects.ContactPage;
//import pageObjects.SignupLoginPage;
//
//public class ContactTests extends BaseTest {
//    BasePage basePage;
//    SignupLoginPage signupLoginPage;
//    ContactPage contactPage;
//
//    @Test(priority = 1)
//    public void contactUsForm() {
//        basePage = new BasePage(getThreadLocal());
//        signupLoginPage = new SignupLoginPage(getThreadLocal());
//        contactPage = new ContactPage(getThreadLocal());
//
//        basePage.verifyHomePage();
//        contactPage.clickContactBtn()
//                .verifyGetInTouchIsVisible()
//                .sendKeysNameInput("Emi")
//                .sendKeysEmailInput("emiliano.castillo@testpro.io")
//                .sendKeysSubjectInput("HelloWorld!!!!!!!")
//                .sendKeysMessageInput("Thanks for the Automation Practice WebSite!")
//                .clickChooseFileBtn("/Users/emiliano/Documents/Agile vs Waterfall.png")
//                .clickSubmitBtn()
//                .verifySuccessMessage()
//                .clickHomeBtn();
//        basePage.verifyHomePage();
//    }
//}