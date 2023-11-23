package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.CartPage;
import pageObjects.SubscriptionFooterPage;

public class SubscriptionFooterTests extends BaseTest {

    BasePage basepage;
    SubscriptionFooterPage subscriptionFooterPage;
    CartPage cartPage;

    @Test(priority = 1, enabled = true, description = "Test Subscription Footer")
    public void scrollDownPageEmailInputSubscription() throws InterruptedException {
        basepage = new BasePage(driver);
        subscriptionFooterPage = new SubscriptionFooterPage(driver);

        basepage.verifyHomePage();
        subscriptionFooterPage.scrollDown()
                .verifyTextSubscription()
                .enterEmailSubField("emiliano.castillo@testpro.io")
                .verifySuccessMessage();
    }

    @Test(priority = 2, enabled = true, description = "Test Subcription in CartsPage")
    public void cartsSubscriptions() throws InterruptedException {
        basepage = new BasePage(driver);
        subscriptionFooterPage = new SubscriptionFooterPage(driver);
        cartPage = new CartPage(driver);

        basepage.verifyHomePage();
        cartPage.clickCartBtn();
        subscriptionFooterPage.scrollDown()
                .verifyTextSubscription()
                .enterEmailSubField("emiliano.castillo@testpro.io")
                .verifySuccessMessage();
    }

    @Test(priority = 3, enabled = true, description = "Test and verify scroll up using Arrow btn and scroll down functionality")
    public void scrollDownBtnTest() {
        basepage = new BasePage(driver);
        subscriptionFooterPage = new SubscriptionFooterPage(driver);

        basepage.verifyHomePage();
        subscriptionFooterPage.scrollDown()
                .verifyTextSubscription()
                .clickArrowBtn()
                .verifyFullFledgedPracticeWebsiteForAutomationEngineers();
    }

//    @Test(priority = 5, enabled = true, description = "Test and verify scroll up without using Arrow btn and scroll down functionality")
//    public void scrollUpTest () {
//        basepage = new BasePage(driver);
//        subscriptionFooterPage = new SubscriptionFooterPage(driver);
//
//        basepage.verifyHomePage();
//        subscriptionFooterPage.scrollDown()
//                .verifyTextSubscription()
//                .scrollUp()
//                .verifyFullFledgedPracticeWebsiteForAutomationEngineers();
//    }
//    @Test(priority = 2, enabled = true, description = "Test Subcription in CartsPage")
//    public void scroll() throws InterruptedException {
//        basepage = new BasePage(driver);
//        subscriptionFooterPage = new SubscriptionFooterPage(driver);
//
//        basepage.verifyHomePage();
//        subscriptionFooterPage.scrollDown();
//        Thread.sleep(4000);
//    }
}