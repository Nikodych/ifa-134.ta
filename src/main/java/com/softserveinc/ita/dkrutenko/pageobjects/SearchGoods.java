package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.By.partialLinkText;
import static org.openqa.selenium.By.xpath;

public class SearchGoods extends BasePage {

    private final By goodsElementsListSelector = xpath("//*[@class='goods-tile__title']");
    private WebElement actualItemElement;

    public SearchGoods(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGoodsList() {

        return waitOnElementsList((goodsElementsListSelector), 30);
    }

    public String getRequiredProductName(String item) {
        var list = getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());

        return list.stream().findFirst().toString();
    }

    public void getActualItem(String text) {
        waitForElementVisibility(partialLinkText(text)).click();
    }

    public void fillSearchField(String text) {
        clickSearchField();
        clearSearchField();
        sendKeysToSearchField(text);
    }
}
