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
    public void verifyProductPhotoChanging() {
        var productPage = homePage
                .openCategory("Ноутбуки та комп’ютери")
                .openSubCategory()
                .openProduct();

        var srcBeforeNavigation = productPage.getImgSource();
        productPage.switchPhotoTo(2);
        var srcAfterNavigation = productPage.getImgSource();

        assertThat(srcBeforeNavigation)
                .as("Image should change")
                .doesNotContain(srcAfterNavigation);
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

    @Test
    public void verifyKitPrice() {
        var kitIndex = 2;
        var productPage = homePage
                .openCategory("Ноутбуки та комп’ютери")
                .openSubCategory()
                .openProduct()
                .switсhKitTo(kitIndex);

        var mainKitProductPrice = productPage.getMainKitProductPrice(kitIndex);
        var additionalKitProductPrice = productPage.getAdditionalKitProductPrice(kitIndex);

        var expectedPrice = mainKitProductPrice + additionalKitProductPrice;
        var actualPrice = productPage.getKitPrice(kitIndex);

        assertThat(expectedPrice)
                .as("Sum of prices should correspond final price")
                .isEqualTo(actualPrice);
    }
}
