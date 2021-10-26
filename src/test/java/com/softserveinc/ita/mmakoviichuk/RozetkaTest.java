package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.pageobjects.rozetka.CategoriesPage;
import com.softserveinc.ita.pageobjects.rozetka.HomePage;
import com.softserveinc.ita.pageobjects.rozetka.ProductPage;
import com.softserveinc.ita.pageobjects.rozetka.WishlistPage;
import com.softserveinc.ita.utils.runners.TestRunner;
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
        HomePage homePage = new HomePage(getDriver());
        String categoryTitle = homePage.getDropdownCategory().toLowerCase();
        homePage.dropdownCategoryClick();
        Assert.assertEquals(categoryTitle, new CategoriesPage(getDriver()).getCategory().toLowerCase());
    }


    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
    }

    @Test(dataProvider = "rozetkaLoginData")
    public void wishlistTest(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.loginInit(email, password);
        getDriver().get("https://rozetka.com.ua/ua/41556706/g41556706/");
        ProductPage productPage = new ProductPage(getDriver());
        productPage.addWish();
        String id = productPage.getId();
        homePage.wishlistClick();
        boolean check = new WishlistPage(getDriver()).containsId(id);
        Assert.assertTrue(check);
    }
}
