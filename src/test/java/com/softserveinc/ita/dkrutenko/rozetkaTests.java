package com.softserveinc.ita.dkrutenko;

import com.softserveinc.ita.pageobjects.Cart;
import com.softserveinc.ita.pageobjects.CartSideMenu;
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
    public void rozetkaSearchTest(String searchItem, String item) {
        SearchField searchField = loadSearch();
        searchField.fillSearch(searchItem);
        searchField.clickSearchButton();
        searchField.waitElementCondition();
        List<String> list = searchField.getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(Collectors.toList());
        Assert.assertTrue(list.get(0).contains(item));
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
    public void rozetkaCartFunctionalTest(String searchItem, String item) {
        SearchField searchField = loadSearch();
        searchField.fillSearch(searchItem);
        searchField.clickSearchButton();
        searchField.waitElementCondition();
        searchField.getExpectedItem(item).click();
        Cart cart = loadCart();
        cart.clickAddToCartButton();
        CartSideMenu cartSideMenu = loadCartSideMenu();
        cartSideMenu.waitElementCondition();
        cartSideMenu.clickContinueButton();
        cartSideMenu.clickHomePage();
        cart.waitElementCondition();
        cart.clickCart();
        cart.waitElementCondition();
        cart.itemString();
        Assert.assertTrue(cart.itemString().contains(item));
        cartSideMenu.deleteFromCart();
        cartSideMenu.waitElementCondition();
        cartSideMenu.clickCartClose();
    }

    @DataProvider
    public Object[][] rozetkaResources() {
        return new Object[][] {
        {" ТМ используется на основании лицензии правообладателя RozetkaLTD. ",
         " ТМ використовується на підставі ліцензії правовласника RozetkaLTD. "}};
}
        @Test(dataProvider = "rozetkaResources")
        public void checkLanguageTest (String ru, String ukr) {
            MainPage mainPage = loadMainPage();
            mainPage.clickLanguageButton();
            mainPage.waitElementCondition();
            mainPage.getMarketName();
            if(mainPage.getMarketName().contains(ru) || mainPage.getMarketName().contains(ukr)) {
                Assert.assertTrue(true);
            }
    }
}
