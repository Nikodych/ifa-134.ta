package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public class GooglePage extends BaseGooglePage {

    private final By wikipediaUrl = By.xpath("//a[contains(@href, 'uk.wikipedia.org')]");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public WikipediaPage openWikipedia() {
        driver
                .findElement(wikipediaUrl)
                .click();

        return new WikipediaPage(driver);
    }
}
