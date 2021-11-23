package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.LoginPageModal;
import com.softserveinc.ita.dkrutenko.pageobjects.rozetka.SearchGoods;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RozetkaTests {

    @BeforeMethod
    public void openUrl() {
        open("https://rozetka.com.ua/");
    }

    private final SearchGoods searchGoods = new SearchGoods();
    private final LoginPageModal loginPageModal = new LoginPageModal();

    @DataProvider
    public Object[][] rozetkaItemsForSearch() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S20 FE"}};
    }

    @Test(dataProvider = "rozetkaItemsForSearch")
    public void verifySearchTest(String brandNameItem, String requiredItem) {
        //fill search with name of some brand and click on search button
        searchGoods.fillSearchField(brandNameItem);
        searchGoods.clickSearchButton();
        //take list of items and filter our required item. Check if that item are actually present
        var actualItem = searchGoods.getRequiredProductName(requiredItem);
        assertThat(actualItem)
                .as("Test fail: Text should be: " + actualItem)
                .contains(requiredItem);
    }

    @DataProvider
    public Object[][] rozetkaProductItems() {
        return new Object[][]{
                {"iphone", "iPhone 12 Pro Max"}};
    }

    @Test(dataProvider = "rozetkaProductItems")
    public void verifyShoppingCartTest(String brandNameItem, String requiredItem) {
        //fill search with some brand name, click search button and click on required product
        searchGoods.fillSearchField(brandNameItem);
        searchGoods.clickSearchButton();
        var shoppingCartPage = searchGoods.findActualItem(requiredItem);
        //add to cart, click continue and go on main page
        var shoppingCartModal = shoppingCartPage.clickAddToCartButton();
        shoppingCartModal.clickCartContinueButton();
        shoppingCartModal.clickLogoIcon();
        //click on 'cart' and get title of our product.
        shoppingCartPage.clickCartButton();
        var getProductTitle = shoppingCartPage.getProductTitle();
        //check if our product title contains required item, after that-delete product from the cart and click on close button
        assertThat(getProductTitle)
                .as("Test fail: Text should be: " + getProductTitle)
                .contains(requiredItem);

        shoppingCartModal.deleteFromShoppingCart();
        shoppingCartModal.clickShoppingCartCloseButton();
    }

    @DataProvider
    public Object[][] rozetkaLangVerification() {
        return new Object[][]{
                {"ТМ используется на основании лицензии правообладателя RozetkaLTD",
                        "ТМ використовується на підставі ліцензії правовласника RozetkaLTD"}};
    }

    @Test(dataProvider = "rozetkaLangVerification")
    public void verifySwitchLanguageTest(String expectedRuText, String expectedUkrText) {
        //switch language in top right corner and check if language was actually changed
        loginPageModal.clickLanguageButton();
        var getTitle = loginPageModal.getMarketNameTitle();
        assertThat(getTitle)
                .as("Test fail: Text should be: " + getTitle)
                .containsAnyOf(expectedRuText, expectedUkrText);
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123"}};
    }

    //dont forget to uncomment chrome options to avoid captcha
    @Test(dataProvider = "rozetkaLoginData")
    public void verifyLoginTest(String email, String password) {
        //click on user button, fill email and password field and click login button
        loginPageModal.clickUserButton();
        loginPageModal.fillEmailField(email);
        loginPageModal.fillPasswordField(password);
        loginPageModal.clickLoginButton();
        //click on sidebar menu, check if we are logged in by verifying email and click logout
        loginPageModal.clickSideUserMenu();
        var userTitle = loginPageModal.getUserEmailTitle();
        assertThat(userTitle)
                .as("Test fail: Text should be: " + userTitle)
                .isEqualTo(email);

        loginPageModal.clickExitButton();
    }
}
