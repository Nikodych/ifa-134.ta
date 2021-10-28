package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class WikipediaPage extends BasePage<WikipediaPage> {

    private final By rozetkaUrl = xpath("//a[contains(@href, 'rozetka.ua')]");

    public WikipediaPage(WebDriver driver) {
        super(driver);
        searchBar = name("search");
        searchButton = xpath("//input[@name = 'go']");
    }

    public void openRozetka() {
        driver
                .findElement(rozetkaUrl)
                .click();
    }
}
