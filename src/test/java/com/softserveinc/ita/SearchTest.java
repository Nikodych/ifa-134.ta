package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.SearchResultPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends TestRunner {

    @Test
    public void verifySearchResultsTest() {
        var homePage = new HomePage();
        var searchResultPage = new SearchResultPage();
        var requiredItem = "Xiaomi Redmi Note 10";
        homePage
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
}
