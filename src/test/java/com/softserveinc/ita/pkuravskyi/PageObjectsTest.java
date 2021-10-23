package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pageobjects.GooglePage;
import com.softserveinc.ita.pageobjects.WikipediaPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.*;

public class PageObjectsTest extends TestRunner {

    @Test
    // Search Wikipedia on google search & open it, find SoftServe article in it & open its website
    public void verifyTest() {
        googlePage = new GooglePage(driver);
        googlePage.searchBarInputText("Wikipedia");
        googlePage.searchButtonClick();
        googlePage.openWikipediaClick();
        wikipediaPage = new WikipediaPage(driver);
        wikipediaPage.searchBarInputText("SoftServe");
        wikipediaPage.searchButtonClick();
        wikipediaPage.selectSoftServeUrlClick();
    }
}
