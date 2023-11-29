package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.TestCasesPage;

public class TestCasesPageTests extends BaseTest {

    BasePage basePage;
    TestCasesPage testCasesPage;

    @Test(priority = 1, enabled = true, description = "Test open Testcases Page")
    public void openTestCasesTab() {
        basePage = new BasePage(getThreadLocal());
        testCasesPage = new TestCasesPage(getThreadLocal());

        basePage.verifyHomePage();
        testCasesPage.clickTestCases()
                .verifyTestCasesPage();
    }
}