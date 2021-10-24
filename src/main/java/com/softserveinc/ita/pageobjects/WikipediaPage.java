package com.softserveinc.ita.pageobjects;

import org.openqa.selenium.*;

public class WikipediaPage extends BaseWikipediaPage {

    private final By rozetkaUrl = By.xpath("//a[contains(@href, 'rozetka.ua')]");

    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    public void openRozetka() {
        driver
                .findElement(rozetkaUrl)
                .click();
    }
}
