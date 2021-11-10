package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka.*;
import com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class RozetkaTest extends TestRunner {

    @Test
    public void categoryTest() {
        HomePage homePage = new HomePage();
        String categoryUrl = homePage.getCategoryUrl(1);
        homePage.openCategory(1);
        Assert.assertEquals(categoryUrl, homePage.getCurrentUrl(categoryUrl));
    }

    @Test
    public void dropdownCategoryTest() {
        HomePage homePage = new HomePage();
        String categoryUrl = homePage.getDropdownCategoryUrl(1);
        homePage.openCategoryFromDropdown(1);
        Assert.assertEquals(categoryUrl, homePage.getCurrentUrl(categoryUrl));
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
    }

    @Test(dataProvider = "rozetkaLoginData")
    public void wishlistTest(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.logIn(email, password);
        open("https://rozetka.com.ua/ua/41556706/g41556706/");

        ProductPage productPage = new ProductPage();
        productPage.addToWishlist();
        String id = productPage.getProductId();
        WishlistPage wishlistPage = homePage.openWishList();

        boolean isProductInWishlist = wishlistPage.isContainsProductId(id);
        Assert.assertTrue(isProductInWishlist);
    }
}
