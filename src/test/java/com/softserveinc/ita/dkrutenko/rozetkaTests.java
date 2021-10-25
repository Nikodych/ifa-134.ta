package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.pageobjects.ShoppingCartPage;
import com.softserveinc.ita.pageobjects.ShoppingCartModal;
import com.softserveinc.ita.pageobjects.MainPage;
import com.softserveinc.ita.pageobjects.SearchField;
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
    //searchItem = samsung or etc; item = some phone or etc.
    public void verifySearchTest(String searchItem, String item) {
        SearchField searchField = loadSearch();
        searchField.fillSearch(searchItem);
        searchField.clickSearchButton();
        searchField.waitElementCondition();
        List<String> list = searchField
                .getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(Collectors.toList());
        Assert.assertTrue(list.get(1).contains(item));
    }

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
        SearchField searchField = loadSearch();
        searchField.fillSearch(searchItem);
        searchField.clickSearchButton();
        searchField.waitElementCondition();
        searchField.getExpectedItem(item).click();
        ShoppingCartPage cart = loadCart();
        cart.clickAddToCartButton();
        ShoppingCartModal shoppingCartModal = loadShoppingCartModal();
        shoppingCartModal.waitElementCondition();
        shoppingCartModal.clickShoppingCartContinueButton();
        MainPage mainPage = loadMainPage();
        mainPage.clickLogo();
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
        MainPage mainPage = loadMainPage();
        mainPage.clickLanguageButton();
        mainPage.waitElementCondition();
        mainPage.getMarketName();
        if (mainPage.getMarketName().contains(ru) || mainPage.getMarketName().contains(ukr)) {
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
        MainPage mainPage = loadMainPage();
        mainPage.waitElementCondition();
        mainPage.clickUserButton();
        mainPage.waitElementCondition();
        mainPage.fillEmailField(email);
        mainPage.fillPasswordField(password);
        mainPage.clickLoginButton();
        mainPage.waitElementCondition();
        mainPage.clickSideUserMenu();
        mainPage.getUserEmailTitle();
    Assert.assertTrue(mainPage.getUserEmailTitle().contains(email));
        mainPage.clickExitButton();
    }
}
