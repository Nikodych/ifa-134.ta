package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.SearchResultPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    @Test
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched")
                .isTrue();
    }

    @Test
    public void verifySearchResultsTest() {
        var requiredItem = "Xiaomi Redmi Note 10";
        homePage
                .closeAdvertisingBannerIfDisplayed()
                .setTextInSearchBar(requiredItem)
                .performSearch();

        var searchResultPage = new SearchResultPage();
        var firstItem = searchResultPage.getGoodsList(requiredItem)
                .stream()
                .findFirst()
                .toString();
        
        assertThat(firstItem)
                .as("Test failed: The first item should contain: " + requiredItem)
                .contains(requiredItem);

        var lastItem = searchResultPage.getGoodsList(requiredItem);
        assertThat(lastItem.get(lastItem.size() - 1))
                .as("Test failed: The last item should contain: " + requiredItem)
                .contains(requiredItem);
    }
}
