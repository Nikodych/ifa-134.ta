package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.pageobjects.GooglePageObject;
import com.softserveinc.ita.pkuravskyi.pageobjects.WikipediaPageObject;
import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.annotations.*;

public class PageObjectsTest extends TestRunner {

    @Test
    // Search Wikipedia on google search & open it, find SoftServe article in it & open its website
    public void verifyTest() {
        googlePage = new GooglePageObject(driver);
        googlePage.searchBarInputText("Wikipedia");
        googlePage.searchButtonClick();
        googlePage.openWikipediaClick();
        wikipediaPage = new WikipediaPageObject(driver);
        wikipediaPage.searchBarInputText("SoftServe");
        wikipediaPage.searchButtonClick();
        wikipediaPage.selectSoftServeUrlClick();
    }
}
