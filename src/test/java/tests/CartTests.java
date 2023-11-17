package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.CartPage;
import pageObjects.ProductsPage;

public class CartTests extends BaseTest {

    BasePage basePage;
    CartPage cartPage;
    ProductsPage productsPage;

    @Test
    public void addProductsToCart() {
        basePage = new BasePage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);

        basePage.verifyHomePage();
        productsPage.clickProductsBtn()
                .hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverSecondProductClickAdd();
        cartPage.clickViewCart()
                .verifyItemsInCart()
                .verifyItemsDetails();
    }
}