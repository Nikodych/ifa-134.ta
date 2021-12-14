package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CategoriesPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.modals.FilterModal;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterModalTest extends TestRunner {

    @DataProvider
    public Object[][] priceSortingFunctionality() {
        return new Object[][]{
                {"Ноутбуки", "2 999", "8 999", "2 998", "9 000"}};
    }

    @Test(dataProvider = "priceSortingFunctionality")
    public void verifyPriceSortingFunctionality(String categoryName, String positiveMinPrice, String positiveMaxPrice,
                                                String negativeMinPrice, String negativeMaxPrice) {
        var homePage = new HomePage();
        homePage.closeAdvertisingBannerIfDisplayed();

        var categoriesPage = new CategoriesPage();
        categoriesPage
                .selectRequiredCategory(categoryName)
                .selectRandomSubCategory();

        var filterModal = new FilterModal();
        var productPage = filterModal
                .setMinimalPrice(positiveMinPrice.replaceAll("\\s", ""))
                .setMaximalPrice(positiveMaxPrice.replaceAll("\\s", ""))
                .clickOnPriceButton();

        filterModal.selectFromCheapToExpensive();
        var firstItemPriceFromCheapToExpensive = productPage.getPriceFromFirstItem();
        assertThat(firstItemPriceFromCheapToExpensive)
                .as("Test failed: Minimal price should be " + positiveMinPrice)
                .isGreaterThanOrEqualTo(positiveMinPrice);

        assertThat(firstItemPriceFromCheapToExpensive)
                .as("Test failed: Minimal price should be greater or equal " + positiveMinPrice)
                .isNotEqualTo(negativeMinPrice);

        filterModal.selectFromExpensiveToCheap();
        var firstItemPriceFromExpensiveToCheap = productPage.getPriceFromFirstItem();
        assertThat(firstItemPriceFromExpensiveToCheap)
                .as("Test failed: Maximal price should be " + positiveMaxPrice)
                .isLessThanOrEqualTo(positiveMaxPrice);

        assertThat(firstItemPriceFromExpensiveToCheap)
                .as("Test failed: Maximal price should be less or equal " + positiveMinPrice)
                .isNotEqualTo(negativeMaxPrice);
    }
}
