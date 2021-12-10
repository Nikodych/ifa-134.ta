package com.softserveinc.ita.deprecated.pkuravskyi;

import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.GooglePage;
import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.WikipediaPage;
import com.softserveinc.ita.deprecated.pkuravskyi.utils.runners.TestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleWikiTest extends TestRunner {

    @BeforeClass
    public void setUpTest() {
        homePage = "https://www.google.com.ua/";
        googlePage = new GooglePage();
        wikipediaPage = new WikipediaPage();
    }

    @Test
    // Search Wikipedia on google search & open it, find rozetka article in it & open its website
    public void verifyWikipediaSearchTest() {

        googlePage.searchBarInputText("Wikipedia");
        var googleSearchBarText = googlePage.getSearchBarText();
        assertThat(googleSearchBarText)
                .as("Text in search bar should be correct")
                .isEqualTo("Wikipedia");

        googlePage
                .searchButtonClick()
                .openWikipedia();
        assertThat(url())
                .as("Ukrainian wikipedia should be opened")
                .contains("uk.wikipedia.org");

        wikipediaPage.searchBarInputText("rozetka.ua");
        var wikipediaSearchBarText = wikipediaPage.getSearchBarText();
        assertThat(wikipediaSearchBarText)
                .as("Text in search bar should be correct")
                .isEqualTo("rozetka.ua");

        wikipediaPage
                .searchButtonClick()
                .openRozetka();
        assertThat(url())
                .as("Rozetka should be opened")
                .isEqualTo("https://rozetka.com.ua/");
    }
}
