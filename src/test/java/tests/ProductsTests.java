package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.ProductsPage;

public class ProductsTests extends BaseTest {

    BasePage basePage;
    ProductsPage productsPage;

    @Test(priority = 1, enabled = true, description = "Test product page and product details")
    public void verifyProductsAndDetails() {
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);

        basePage.verifyHomePage();
        productsPage.clickProductsBtn()
                .verifyProductsPage()
                .clickViewProduct()
                .verifyFirstProductIsVisible()
                .verifyProductDetails();
    }

    @Test(priority = 2, enabled = true, description = "Test Product Search")
    public void searchProduct() {
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);

        basePage.verifyHomePage();
        productsPage.clickProductsBtn()
                .verifyProductsPage()
                .searchFieldInput("Blue Top")
                .verifySearchedProductIsVisible()
                .searchFieldInput("Jeans")
                .verifyAllProductsForJeansSearchAreVisible();
    }

    @Test(priority = 3, enabled = true, description = "Test View Category Products SideBar")
    public void categoryProducts() {
        productsPage = new ProductsPage(driver);

        productsPage.verifyCategoriesIsVisible()
                .clickWomen()
                .clickDress()
                .verifyCategoryPageAndConfirmText()
                .clickMen()
                .clickJeans()
                .verifyCategoryPageJeans();
    }

    @Test(priority = 4, enabled = true, description = "Test View And Cart Brand Products")
    public void viewCartBrandProducts() {
        productsPage = new ProductsPage(driver);

        productsPage.clickProductsBtn()
                .verifyBrandsAreVisible()
                .clickBibaProductBrand()
                .verifyBrandPageAndProductsForBiba()
                .clickPoloProductBrand()
                .verifyBrandPageAndProductsForPolo();
    }
}