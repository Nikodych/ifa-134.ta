package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

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
    public void verifySearchTest(String searchItem, String item) {
        searchGoods.fillSearch(searchItem);
        searchGoods.clickSearchButton();
        searchGoods.waitElementCondition();
        List<String> list = searchGoods
                .getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(Collectors.<String>toList());
        Assert.assertTrue(list.stream().findFirst().toString().contains(item));
    }

    @DataProvider
    public Object[][] rozetkaCheckCartItems() {
        return new Object[][]{
                {"samsung", "Samsung Galaxy S21"},
                {"iphone", "iPhone 12 Pro Max"},
                {"samsung", "Samsung Galaxy A72"}};
    }

    @Test(dataProvider = "rozetkaCheckCartItems")
    public void verifyShoppingCartTest(String searchItem, String item) {
        searchGoods.fillSearch(searchItem);
        searchGoods.clickSearchButton();
        searchGoods.waitElementCondition();
        searchGoods.getActualItem(item).click();
            shoppingCartPage.clickAddToCartButton();
                shoppingCartModal.waitElementCondition();
                shoppingCartModal.clickShoppingCartContinueButton();
                shoppingCartModal.clickLogo();
            shoppingCartPage.waitElementCondition();
            shoppingCartPage.clickCartButton();
            shoppingCartPage.waitElementCondition();
            shoppingCartPage.getProductTitle();
        Assert.assertTrue(shoppingCartPage.getProductTitle().contains(item));
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
}
