package tests;

import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.CartPage;
import pageObjects.ProductsPage;
import pageObjects.SignupLoginPage;

public class ProductsTests extends BaseTest {

    BasePage basePage;
    ProductsPage productsPage;
    CartPage cartPage;
    SignupLoginPage signupLoginPage;

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

    @Test(priority = 5, enabled = true, description = "Test Search Products and Verify CArt After Login")
    public void searchProductsAndVerifyCartAfterLogin() {
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        signupLoginPage = new SignupLoginPage(driver);

        productsPage.clickProductsBtn()
                .verifyProductsPage()
                .searchFieldInput("Blue Top")
                .verifySearchedProductIsVisible()
                .verifyAllProductsForBlueTopSearchAreVisible()
                .hoverOverProductClickAdd();
        cartPage.clickContinue()
                .clickCartBtn()
                .verifyBlueTopItemInCart();
        signupLoginPage.clickSignupBtn()
                .verifyNewUserSignupIsVisible()
                //Register with name and email
                .sendKeysNameInput("Emiliano")
                .sendKeysEmailInput("emiliano.castillo@testpro.io")
                .submitSignupBtn()
                .verifyEnterAccountInformationIsVisible()
                //Fill out form
                .genderSelect()
                .nameInput("Emiliano")
                .passwordInput("ABC123")
                .clickDayDropdown()
                .selectDay()
                .clickMonthDropdown()
                .selectMonth()
                .clickYearDropdown()
                .selectYear()
                .checkboxSignupForOurNewsletter()
                .checkboxSpecialOffers()
                .firstNameInput("Emiliano")
                .lastNameInput("Castillo")
                .companyNameInput("eacwebdev")
                .addressNameInput("4109 E tenth ave")
                .address2NameInput("Milo")
                .countryDropdown()
                .selectCountry()
                .stateNameInput("Colorado")
                .cityNameInput("Denver")
                .zipcodeInput("80220")
                .mobileNumberInput("777 777 7777")
                .clickCreateBtn()
                .verifyAccountCreated()
                .clickContinueBtn()
                .verifyLoggedInAsUserName()
                .logout()
                .clickSignupBtn()
                .loginWithCorrectCredentials();
        cartPage.clickCartBtn()
                .verifyBlueTopItemInCart();
        signupLoginPage.clickDeleteBtn();
    }

    @Test(priority = 5, enabled = true, description = "Test Adding Products Review")
    public void productReview() {
        productsPage = new ProductsPage(driver);

        productsPage.clickProductsBtn()
                .verifyProductsPage()
                .clickViewProduct()
                .verifyWriteYourReviewIsVisible()
                .enterNameEmailAndReview()
                .verifySuccessMessage();
    }
}