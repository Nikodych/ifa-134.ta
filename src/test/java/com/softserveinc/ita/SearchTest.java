package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CategoriesPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends TestRunner {
    private final HomePage homePage = new HomePage();

    @Test
    public void verifySearchResultsTest() {

        var requiredItem = "Xiaomi Redmi Note 10";
        var searchResultPage = homePage
                .closeAdvertisingBannerIfDisplayed()
                .setTextInSearchBar(requiredItem)
                .performSearch();

        var firstItem = searchResultPage
                .getGoodsListBy(requiredItem)
                .stream()
                .findFirst()
                .toString();

        assertThat(firstItem)
                .as("Test failed: The first item should contain: " + requiredItem)
                .contains(requiredItem);

        var lastItem = searchResultPage.getGoodsListBy(requiredItem);
        assertThat(lastItem.get(lastItem.size() - 1))
                .as("Test failed: The last item should contain: " + requiredItem)
                .contains(requiredItem);
    }

    @Test
    public void verifyRecentlyViewedProducts() {
        var category = "Ноутбуки";
        var categoriesPage = new CategoriesPage();

        var expectedItem = categoriesPage
                .closeAdvertisingBannerIfDisplayed()
                .selectRequiredCategory(category)
                .selectRandomSubCategory()
                .selectFirstItemFromProductPage()
                .getProductTitle();

        var lastViewedItemFromMainPage = homePage
                .clickOnMainPageLogo()
                .homePageLastViewedProductTitle(expectedItem);

        assertThat(lastViewedItemFromMainPage)
                .as("Test failed: last viewed item must be: " + expectedItem)
                .contains(expectedItem);

        var lastViewedItemTitle = homePage
                .clickOnLastViewedItem()
                .getProductTitle();

        assertThat(lastViewedItemTitle)
                .as("Test failed: last viewed item must be: " + expectedItem)
                .contains(expectedItem);
    }
}
