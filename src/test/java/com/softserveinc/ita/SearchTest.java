package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CategoriesPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.assertj.core.api.SoftAssertions;
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

        var lastItem = searchResultPage.getGoodsListBy(requiredItem);

        var soft = new SoftAssertions();
        soft.assertThat(firstItem)
                .as("Test failed: The first item should contain: " + requiredItem)
                .contains(requiredItem);

        soft.assertThat(lastItem.get(lastItem.size() - 1))
                .as("Test failed: The last item should contain: " + requiredItem)
                .contains(requiredItem);
        soft.assertAll();
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

        var listOfLastViewedProductsTitles = homePage
                .clickOnMainPageLogo()
                .getTitlesFromListOfLastViewedProducts();

        var lastViewedProductTitle = homePage
                .openLastViewedItemByTitle(expectedItem)
                .getProductTitle();

        var soft = new SoftAssertions();
        soft.assertThat(listOfLastViewedProductsTitles)
                .as("Test failed: last viewed item from list should be: " + expectedItem)
                .contains(expectedItem);

        soft.assertThat(lastViewedProductTitle)
                .as("Test failed: last viewed product should be: " + expectedItem)
                .contains(expectedItem);
        soft.assertAll();
    }
}
