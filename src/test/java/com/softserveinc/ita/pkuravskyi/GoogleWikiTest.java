package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.pageobjects.GooglePage;
import com.softserveinc.ita.pkuravskyi.pageobjects.WikipediaPage;
import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.softserveinc.ita.pkuravskyi.pageobjects.BasePage.getCurrentUrl;

public class GoogleWikiTest extends TestRunner {

    @BeforeClass
    public void openGoogle() {
        homePage = "https://www.google.com.ua/";
        googlePage = new GooglePage();
        wikipediaPage = new WikipediaPage();
    }

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
        Assert.assertEquals(getCurrentUrl(), "https://rozetka.com.ua/");
    }
}
