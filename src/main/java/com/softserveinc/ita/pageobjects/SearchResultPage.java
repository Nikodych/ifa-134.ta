package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

public class SearchResultPage extends BasePage<SearchResultPage> {

    public List<String> getGoodsListBy(String productName) {
        return $$x("//*[@class='goods-tile__title']")
                .shouldBe(sizeGreaterThan(0), ofSeconds(8))
                .stream()
                .map(SelenideElement::getText)
                .filter(text -> text.contains(productName))
                .collect(toList());
    }

    public ProductPage selectFirstItemFromProductPage() {
        $$x("//div[@class='goods-tile__inner']")
                .shouldHave(sizeNotEqual(0), ofSeconds(8))
                .stream()
                .findFirst()
                .get()
                .click();

        return new ProductPage();
    }
}
