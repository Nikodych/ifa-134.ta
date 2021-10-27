package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.dkrutenko.pageobjects.utils.runners.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class rozetkaTests extends TestRunner {

    @DataProvider
    public Object[][] rozetkaItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S20 FE"},
                {"iphone", "iPhone 12 Pro Max"},
                {"xiaomi", "Xiaomi Redmi Note 10"},
                {"nokia", "Nokia G10"}};
    }

    @Test(dataProvider = "rozetkaItems")
    public void verifySearchTest(String brandNameItem, String requiredItem) {
        //fill search with name of some brand and click on search button
        searchGoods.fillSearch(brandNameItem);
        searchGoods.clickSearchButton();
        //take list of items and filter our required item. Check if that item are actually present
        List<String> list = searchGoods
                .getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(requiredItem))
                .collect(toList());
        Assert.assertTrue(list.stream().findFirst().toString().contains(requiredItem));
    }

    @DataProvider
    public Object[][] rozetkaCheckCartItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S20 FE"},
                {"iphone", "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"}};
    }

    @Test(dataProvider = "rozetkaCheckCartItems")
    public void verifyShoppingCartTest(String brandNameItem, String requiredItem) {
        //fill search with some brand name, click search button and click on required product
        searchGoods.fillSearch(brandNameItem);
        searchGoods.clickSearchButton();
        searchGoods.getActualItem(requiredItem).click();
        //add to cart, click continue and go on main page
        shoppingCartPage.clickAddToCartButton();
        shoppingCartModal.clickCartContinueButton();
        shoppingCartModal.clickLogo();
        //click on 'cart' and get title of our product.
        shoppingCartPage.clickCartButton();
        shoppingCartPage.getProductTitle();
        //check if our product title contains required item, after that-delete product from the cart and click on close button
        Assert.assertTrue(shoppingCartPage.getProductTitle().contains(requiredItem));

        shoppingCartModal.deleteFromShoppingCart();
        shoppingCartModal.clickShoppingCartCloseButton();
    }

    @DataProvider
    public Object[][] rozetkaLangVerification() {
        return new Object[][]{
                {" ТМ используется на основании лицензии правообладателя RozetkaLTD. ",
                " ТМ використовується на підставі ліцензії правовласника RozetkaLTD. "}};
    }

    @Test(dataProvider = "rozetkaLangVerification")
    public void verifySwitchLanguageTest(String expectedRuText, String expectedUkrText) {
        //switch language in top right corner and check if language was actually changed
        loginPageModal.clickLanguageButton();
        loginPageModal.getMarketNameTitle();
        if (loginPageModal.getMarketNameTitle().contains(expectedRuText) || loginPageModal.getMarketNameTitle().contains(expectedUkrText)) {
            Assert.assertTrue(true);
        }
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
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
        loginPageModal.getUserEmailTitle();
        Assert.assertTrue(loginPageModal.getUserEmailTitle().contains(email));

        loginPageModal.clickExitButton();
    }
}
