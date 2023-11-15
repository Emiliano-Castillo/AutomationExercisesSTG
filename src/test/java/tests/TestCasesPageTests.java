package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.TestCasesPage;

public class TestCasesPageTests extends BaseTest {

    BasePage basePage;
    TestCasesPage testCasesPage;

    @Test(enabled = true, description = "Test open Testcases Page")
    public void openTestCasesTab() {
        basePage = new BasePage(driver);
        testCasesPage = new TestCasesPage(driver);

        basePage.verifyHomePage();
        testCasesPage.clickTestCases()
                .verifyTestCasesPage();
    }
}