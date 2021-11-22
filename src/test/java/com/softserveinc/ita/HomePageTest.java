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
        assertThat(firstItem)
                .as("Test failed: First item should contains: " + requiredItem)
                .contains(requiredItem);

        assertThat(lastItem)
                .as("Test failed: Last item should contains: " + requiredItem)
                .contains(requiredItem);
    }

    @DataProvider
    public Object[][] priceSortingFunctionality() {
        return new Object[][]{
                {"3999", "9999"}};
    }

    @Test(dataProvider = "priceSortingFunctionality")
    public void verifyPriceSortingFunctionality(String minPrice, String maxPrice) {
        homePage.selectCategory();
        homePage.selectSubcategory();

        homePage.setMinimalPrice(minPrice);
        homePage.setMaximalPrice(maxPrice);
        homePage.clickOnPriceButton();

        homePage.selectFromCheapToExpensive();
        var fromCheapToExpensivePrice = homePage.listOfPrices(minPrice);
        System.out.println(fromCheapToExpensivePrice);
        assertThat(fromCheapToExpensivePrice)
                .as("Test failed: Minimal price should be " + minPrice)
                .containsAnyOf(minPrice);

       /* homePage.selectFromExpensiveToCheap();
        var fromExpensiveToCheapPrice = homePage.getFirstItemPrice(maxPrice);
        assertThat(fromExpensiveToCheapPrice)
                .as("Test failed: Maximal price should be " + maxPrice)
                .contains(maxPrice);

        */
    }
}