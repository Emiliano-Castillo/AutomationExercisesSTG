package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.ProductsPage;

public class ProductsTests extends BaseTest {

    BasePage basePage;
    ProductsPage productsPage;

    @Test(enabled = true, description = "Test product page and product details")
    public void verifyProductsAndDetails() throws InterruptedException {
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);

        basePage.verifyHomePage();
        productsPage.clickProductsBtn()
                .verifyProductsPage()
                .clickViewProduct()
                .verifyFirstProductIsVisible()
                .verifyProductDetails();
    }
}