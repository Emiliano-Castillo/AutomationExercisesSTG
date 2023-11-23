package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.CartPage;
import pageObjects.ProductsPage;

public class CartTests extends BaseTest {

    BasePage basePage;
    CartPage cartPage;
    ProductsPage productsPage;

    @Test(priority = 1, enabled = true, description = "Test Adding Products to Cart")
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

    @Test(priority = 2, enabled = true, description = "Test Product Quantity")
    public void verifyingProductQuantityInCart() {
        basePage = new BasePage(driver);
        cartPage = new CartPage(driver);

        basePage.verifyHomePage();
        cartPage.clickStylishDressViewProduct()
                .inputQuantity("4")
                .addToCart()
                .clickViewCart()
                .verifyItemQuantity();
    }

    @Test(priority = 3, enabled = true, description = "Test Removing products from Cart")
    public void RemovingProductsFromCart() {
        basePage = new BasePage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);

        basePage.verifyHomePage();
        productsPage.hoverOverProductClickAdd();
        cartPage.clickContinue();
        productsPage.hoverOverFifthProductClickAdd();
        cartPage.clickCartBtn()
                .verifyCartPage()
                .clickX()
                .verifyRemovelOfProduct();
    }
}