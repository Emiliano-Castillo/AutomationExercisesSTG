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