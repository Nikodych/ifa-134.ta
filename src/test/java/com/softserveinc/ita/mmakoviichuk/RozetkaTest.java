package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka.*;
import com.softserveinc.ita.mmakoviichuk.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RozetkaTest extends TestRunner {

    @Test
    public void categoryTest() {
        String categoryTitle = new HomePage(getDriver()).getCategory().toLowerCase();
        new HomePage(getDriver()).categoryClick();
        Assert.assertEquals(categoryTitle, new CategoriesPage(getDriver()).getCategory().toLowerCase());
    }

    @Test
    public void dropdownCategoryTest() {
        RozetkaBasePage rozetkaBasePage = new RozetkaBasePage(getDriver());
        String categoryTitle = rozetkaBasePage.getDropdownCategory().toLowerCase();
        rozetkaBasePage.dropdownCategoryClick();
        Assert.assertEquals(categoryTitle, new CategoriesPage(getDriver()).getCategory().toLowerCase());
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
        productPage.addWish();
        String id = productPage.getId();
        rozetkaBasePage.wishlistClick();
        boolean isProductInWishlist = new WishlistPage(getDriver()).containsId(id);
        Assert.assertTrue(isProductInWishlist);
    }
}
