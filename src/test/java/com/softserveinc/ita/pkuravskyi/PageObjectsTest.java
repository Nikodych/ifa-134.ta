package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.*;

public class PageObjectsTest extends TestRunner {

    @Test
    // Search Wikipedia on google search & open it, find rozetka article in it & open its website
    public void verifyWikipediaSearchTest() {
        googlePage.searchBarInputText("Wikipedia");
        Assert.assertEquals(googlePage.getSearchBarText(), "Wikipedia");
        googlePage
                .searchButtonClick()
                .openWikipedia();

        wikipediaPage.searchBarInputText("rozetka.ua");
        Assert.assertEquals(wikipediaPage.getSearchBarText(), "rozetka.ua");
        wikipediaPage
                .searchButtonClick()
                .openRozetka();
    }
}
