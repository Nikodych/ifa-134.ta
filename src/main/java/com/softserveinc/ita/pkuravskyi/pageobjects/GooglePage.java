package com.softserveinc.ita.pkuravskyi.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class GooglePage extends BasePage<GooglePage> {

    private final String wikipediaUrlSelector = "//a[contains(@href, 'uk.wikipedia.org')]";

    public GooglePage() {
        searchBar = "//input[@name = 'q']";
        searchButton = "//input[@name = 'btnK']";
    }

    public WikipediaPage openWikipedia() {
        $x(wikipediaUrlSelector).click();

        return new WikipediaPage();
    }
}
