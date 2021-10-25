package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.pageobjects.*;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

public class rozetkaTests extends TestRunner {

    @DataProvider
    public Object[][] rozetkaItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone", "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy Watch 4 Classic"},
                {"nokia", "Nokia G10"}};
    }

    @Test(dataProvider = "rozetkaItems")
    //searchItem = samsung or etc; item = some phone or etc.
    public void verifySearchTest(String searchItem, String item) {
        SearchGoods searchGoods = loadSearchGoods();
        searchGoods.clickSearch();
        searchGoods.clearSearch();
        searchGoods.sendKeysSearch(searchItem);
        searchGoods.clickSearchButton();
        searchGoods.waitElementCondition();
        List<String> list = Collections.singletonList(searchGoods
                .getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Message")));
        Assert.assertTrue(list.contains(item));
    }
/*
    @DataProvider
    public Object[][] rozetkaCheckCartItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone", "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"}};
    }

    @Test(dataProvider = "rozetkaCheckCartItems")
    //searchItem = samsung or etc; item = some phone or etc.
    public void verifyShoppingCartTest(String searchItem, String item) {
        SearchGoods searchGoods = loadSearchGoods();
        searchGoods.fillSearch(searchItem);
        searchGoods.clickSearchButton();
        searchGoods.waitElementCondition();
        searchGoods.getExpectedItem(item).click();
        ShoppingCartPage cart = loadShoppingCartPage();
        cart.clickAddToCartButton();
        ShoppingCartModal shoppingCartModal = loadShoppingCartModal();
        shoppingCartModal.waitElementCondition();
        shoppingCartModal.clickShoppingCartContinueButton();
        LoginPageModal loginPageModal = loadLoginPageModal();
        loginPageModal.clickLogo();
        cart.waitElementCondition();
        cart.clickCartButton();
        cart.waitElementCondition();
        cart.getProductTitle();
        Assert.assertTrue(cart.getProductTitle().contains(item));
        shoppingCartModal.deleteFromShoppingCart();
        shoppingCartModal.waitElementCondition();
        shoppingCartModal.clickShoppingCartCloseButton();
    }

    @DataProvider
    public Object[][] rozetkaLangVerification() {
        return new Object[][]{
                {" ТМ используется на основании лицензии правообладателя RozetkaLTD. ",
                        " ТМ використовується на підставі ліцензії правовласника RozetkaLTD. "}};
    }

    @Test(dataProvider = "rozetkaLangVerification")
    public void verifySwitchLanguageTest(String ru, String ukr) {
        LoginPageModal loginPageModal = loadLoginPageModal();
        loginPageModal.clickLanguageButton();
        loginPageModal.waitElementCondition();
        loginPageModal.getMarketName();
        if (loginPageModal.getMarketName().contains(ru) || loginPageModal.getMarketName().contains(ukr)) {
            Assert.assertTrue(true);
        }
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
    }

    @Test(dataProvider = "rozetkaLoginData")
    public void verifyLoginTest(String email, String password) {
        LoginPageModal loginPageModal = loadLoginPageModal();
        loginPageModal.waitElementCondition();
        loginPageModal.clickUserButton();
        loginPageModal.waitElementCondition();
        loginPageModal.fillEmailField(email);
        loginPageModal.fillPasswordField(password);
        loginPageModal.clickLoginButton();
        loginPageModal.waitElementCondition();
        loginPageModal.clickSideUserMenu();
        loginPageModal.getUserEmailTitle();
        Assert.assertTrue(loginPageModal.getUserEmailTitle().contains(email));
        loginPageModal.clickExitButton();
    }
    @Test
    public void someTest() {
        SearchGoods searchGoods = loadSearchGoods();
    }

 */
}
