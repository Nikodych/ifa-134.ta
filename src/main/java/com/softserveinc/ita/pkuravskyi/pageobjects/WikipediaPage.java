package com.softserveinc.ita.pkuravskyi.pageobjects;

import static com.codeborne.selenide.Selenide.$x;

public class WikipediaPage extends BasePage<WikipediaPage> {

    private static final String rozetkaUrl = "//a[contains(@href, 'rozetka.ua')]";

    public WikipediaPage() {
        searchBar = "//input[@name = 'search']";
        searchButton = "//input[@name = 'go']";
    }

    public RozetkaPage openRozetka() {
        $x(rozetkaUrl).click();

        return new RozetkaPage();
    }
}
