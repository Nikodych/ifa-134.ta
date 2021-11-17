package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.rozetka.*;
import com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"},
                {"Товари для дому"}
        };
    }
    @Test(dataProvider = "rozetkaCategoryData")
    public void categoryTest(String title) {
        HomePage homePage = new HomePage();
        homePage.openCategory(title);

        assertThat(title).contains(new CategoryPage().getCategoryTitle());
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void dropdownCategoryTest(String title) {
        HomePage homePage = new HomePage();
        homePage.openCategoryFromDropdown(title);

        assertThat(title).contains(new CategoryPage().getCategoryTitle());
    }

    @DataProvider
    public Object[][] rozetkaLoginData() {
        return new Object[][]{
                {"dospecwork@gmail.com", "Qwerty123",}};
    }

    @Test(enabled = false, dataProvider = "rozetkaLoginData")
    public void wishlistTest(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.logIn(email, password);
        open("https://rozetka.com.ua/ua/41556706/g41556706/");

        ProductPage productPage = new ProductPage();
        productPage.addToWishlist();
        String id = productPage.getProductId();
        WishlistPage wishlistPage = homePage.openWishList();

        boolean isProductInWishlist = wishlistPage.isContainsProductId(id);
        assertThat(isProductInWishlist)
                .as("Product" + "product should be in wishlist")
                .isTrue();
    }
}
