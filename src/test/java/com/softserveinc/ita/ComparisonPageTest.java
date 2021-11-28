package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.ComparisonPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.SearchResultPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonPageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @Test
    public void verifyComparisonPageFunctionalityTest() {
        var testCategoryName = "Ноутбуки та комп’ютери";

        homePage
                .openCategory(testCategoryName)
                .openSubCategory();

        var searchResultPage = new SearchResultPage();

        searchResultPage
                .addProductToCompare()
                .openComparisonPage();

        var comparisonPage = new ComparisonPage();

        assertThat(comparisonPage.isOnlyDifferencesButtonDisplayed())
                .as("'Only differences' button should not be displayed if there are not enough products to compare")
                .isFalse();

        comparisonPage
                .addAnotherProductToCompare()
                .addProductToCompare()
                .addProductToCompare()
                .openComparisonPage();

        var comparisonShareLink = comparisonPage.shareComparisonList();
        var currentUrl = comparisonPage.getUrlText();
        assertThat(comparisonShareLink)
                .as("Share link should match current url")
                .isEqualTo(currentUrl);

        var productsQuantityInCompareListBeforeDelete = comparisonPage.getProductsQuantityInCompareList();
        var productsQuantityInCompareListAfterDelete = comparisonPage
                .removeProductFromCompare()
                .getProductsQuantityInCompareList();

        assertThat(productsQuantityInCompareListAfterDelete)
                .as("One product should be removed from compare")
                .isEqualTo(productsQuantityInCompareListBeforeDelete - 1);

        comparisonPage.showOnlyDifferencesBetweenProducts();

        assertThat(comparisonPage.areOnlyDifferentCharacteristicsShowing())
                .as("Only different characteristics should be shown in compare")
                .isTrue();
    }
}
