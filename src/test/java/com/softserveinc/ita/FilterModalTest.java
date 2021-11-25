package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterModalTest {

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
        var fromCheapToExpensivePrice = productPage.getPriceFromFirstItem();
        assertThat(fromCheapToExpensivePrice)
                .as("Test failed: Minimal price should be " + minPrice)
                .isGreaterThanOrEqualTo(minPrice);

        productPage.selectFromExpensiveToCheap();
        var fromExpensiveToCheapPrice = productPage.getPriceFromFirstItem();
        assertThat(fromExpensiveToCheapPrice)
                .as("Test failed: Maximal price should be " + maxPrice)
                .isLessThanOrEqualTo(maxPrice);
    }
}
