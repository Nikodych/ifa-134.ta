package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterModalTest extends TestRunner {

    @DataProvider
    public Object[][] priceSortingFunctionality() {
        return new Object[][]{
                {"Ноутбуки", "2 999", "8 999"}};
    }

    @Test(dataProvider = "priceSortingFunctionality")
    public void verifyPriceSortingFunctionality(String categoryName, String minPrice, String maxPrice) {
        var homePage = new HomePage();
        homePage
                .closeAdvertisingBannerIfDisplayed()
                .selectRequiredCategory(categoryName)
                .selectRandomSubCategory();

        var productPage = new ProductPage();
        productPage
                .setMinimalPrice(minPrice.replaceAll("\\s", ""))
                .setMaximalPrice(maxPrice.replaceAll("\\s", ""))
                .clickOnPriceButton();

        productPage.selectFromCheapToExpensive();
        var firstItemPriceFromCheapToExpensive = productPage.getPriceFromFirstItem();
        assertThat(firstItemPriceFromCheapToExpensive)
                .as("Test failed: Minimal price should be " + minPrice)
                .isGreaterThanOrEqualTo(minPrice);

        productPage.selectFromExpensiveToCheap();
        var firstItemPriceFromExpensiveToCheap = productPage.getPriceFromFirstItem();
        assertThat(firstItemPriceFromExpensiveToCheap)
                .as("Test failed: Maximal price should be " + maxPrice)
                .isLessThanOrEqualTo(maxPrice);
    }
}
