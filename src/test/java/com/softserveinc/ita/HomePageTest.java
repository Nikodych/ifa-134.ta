package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.BasketModal;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"}
        };
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void cartTest(String title) {
        homePage.openCategory(title);
        categoriesPage.openSubCategory();
        categoriesPage.openProduct();

        var productTitle = productPage.getProductTitle();
        BasketModal basketModal = productPage.addToCart();

        assertThat(basketModal.isProductInBasket(productTitle))
                .as("Product should be in cart")
                .isTrue();
    }

    @Test
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched")
                .isTrue();
    }
}
