package com.softserveinc.ita.dkrutenko.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SearchGoods extends BasePage {

    private List<WebElement> goodsElementsList;
    private WebElement actualItemElement;

    public SearchGoods(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getGoodsList() {
        goodsElementsList = waitOnElementsList(By.xpath("//*[@class='goods-tile__title']"), 30);

        return goodsElementsList;
    }

    public String getRequiredProductName(String item) {
        var list = getGoodsList()
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(item))
                .collect(toList());

        return list.stream().findFirst().toString();
    }

    public WebElement getActualItem(String text) {
        actualItemElement = waitForElementVisibility(By.partialLinkText(text));

        return actualItemElement;
    }

    public void fillSearchField(String text) {
        clickSearchField();
        clearSearchField();
        sendKeysToSearchField(text);
    }
}
