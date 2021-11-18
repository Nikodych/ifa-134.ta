package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.BasePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageTest extends TestRunner {

    @DataProvider
    public Object[][] rozetkaItemsForSearch() {
        return new Object[][]{
                {"Xiaomi Redmi Note 10"}};
    }

    @Test(dataProvider = "rozetkaItemsForSearch")
    public void verifySearchTest(String requiredItem) {
        //fill search with name of some brand and click on search button
        homePage.searchBarInputField(requiredItem);
        homePage.clickSearchButon();
        var firstItem = homePage.getFirstRequiredItem(requiredItem);
        var lastItem = homePage.getLastRequiredItem(requiredItem);
        assertThat(firstItem)
                .as("Test fail: First item should contains: " + requiredItem)
                .contains(requiredItem);

        assertThat(lastItem)
                .as("Test fail: Last item should contains: " + requiredItem)
                .contains(requiredItem);
    }
}
