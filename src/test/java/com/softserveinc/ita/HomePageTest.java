package com.softserveinc.ita;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.DataProvider;
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
    public void verifySearchTest() {
        var requiredItem = "Xiaomi Redmi Note 10";
        homePage.searchBarInputField(requiredItem);
        homePage.clickSearchButton();
        var firstItem = homePage.getFirstRequiredItem(requiredItem);
        var lastItem = homePage.getLastRequiredItem(requiredItem);
        AssertionsForClassTypes.assertThat(firstItem)
                .as("Test failed: First item should contains: " + requiredItem)
                .contains(requiredItem);

        AssertionsForClassTypes.assertThat(lastItem)
                .as("Test failed: Last item should contains: " + requiredItem)
                .contains(requiredItem);
    }
}
