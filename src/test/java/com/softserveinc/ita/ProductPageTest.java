package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @Test
    public void verifyProductSwitchingTabsTest() {
        var testCategoryName = "Ноутбуки та комп’ютери";
        var testProductTabName = "Характеристики";

        homePage
                .openCategory(testCategoryName)
                .openSubCategory()
                .openProduct()
                .switchProductTabTo(testProductTabName);

        var productPage = new ProductPage();

        assertThat(productPage.isCorrectTabDisplayed())
                .as("Correct product tab should be displayed")
                .isTrue();
    }

    @Test
    public void verifyDiscountPrice() {
        var productPage = homePage
                .openDiscountCategory()
                .openProduct();

        var preDiscountPrice = productPage.getProductPriceBeforeDiscount();
        var currentPrice = productPage.getProductPrice();

        assertThat(currentPrice)
                .as("Price with discount should be lower than old price")
                .isLessThan(preDiscountPrice);
    }
}
