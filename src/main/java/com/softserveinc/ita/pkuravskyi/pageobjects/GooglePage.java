package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class GooglePage extends BasePage<GooglePage> {

    private final By wikipediaUrl = xpath("//a[contains(@href, 'uk.wikipedia.org')]");

    public GooglePage(WebDriver driver) {
        super(driver);
        searchBar = name("q");
        searchButton = name("btnK");
    }

    public WikipediaPage openWikipedia() {
        $x(wikipediaUrl).click();

        return new WikipediaPage(driver);
    }
}
