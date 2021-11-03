package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka.*;
import com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RozetkaTest extends TestRunner {

    @Test
    public void categoryTest() {
        HomePage homePage = new HomePage(getDriver());
        String categoryUrl = homePage.getCategoryUrl(1);
        homePage.categoryClick(1);
        Assert.assertEquals(categoryUrl, new CategoriesPage(getDriver()).getCategoryUrl(categoryUrl));
    }

    @Test
    public void dropdownCategoryTest() {
        RozetkaBasePage rozetkaBasePage = new RozetkaBasePage(getDriver());
        String categoryUrl = rozetkaBasePage.getDropdownCategoryUrl(1);
        rozetkaBasePage.dropdownCategoryClick(1);
        Assert.assertEquals(categoryUrl, new CategoriesPage(getDriver()).getCategoryUrl(categoryUrl));
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
    }

    @Test(dataProvider = "rozetkaLoginData")
    public void wishlistTest(String email, String password) {
        RozetkaBasePage rozetkaBasePage = new RozetkaBasePage(getDriver());
        rozetkaBasePage.logIn(email, password);
        getDriver().get("https://rozetka.com.ua/ua/41556706/g41556706/");
        ProductPage productPage = new ProductPage(getDriver());
        productPage.addToWishlist();
        String id = productPage.getProductId();
        rozetkaBasePage.openWishList();
        boolean isProductInWishlist = new WishlistPage(getDriver()).isContainsProductId(id);
        Assert.assertTrue(isProductInWishlist);
    }
}