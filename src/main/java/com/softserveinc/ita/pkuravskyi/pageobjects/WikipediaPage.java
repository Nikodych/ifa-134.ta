package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class WikipediaPage extends BasePage<WikipediaPage> {

    private final By rozetkaUrl = xpath("//a[contains(@href, 'rozetka.ua')]");

    public WikipediaPage() {
        searchBar = name("search");
        searchButton = xpath("//input[@name = 'go']");
    }

    public void openRozetka() {
        $x(rozetkaUrl).click();
    }
}
