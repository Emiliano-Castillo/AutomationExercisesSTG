package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.SubscriptionFooterPage;

public class SubscriptionFooterTests extends BaseTest {
    BasePage basepage;
    SubscriptionFooterPage subscriptionFooterPage;

    @Test(priority = 1, enabled = true, description = "Test Subscription Footer")
    public void scrollDownPageEmailInputSubscription() throws InterruptedException {
        basepage = new BasePage(driver);
        subscriptionFooterPage = new SubscriptionFooterPage(driver);

        basepage.verifyHomePage();
        subscriptionFooterPage.verifyTextSubscription()
                .enterEmailSubField("emiliano.castillo@testpro.io")
                .verifySuccessMessage();
    }
}