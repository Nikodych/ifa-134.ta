package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
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

    public SearchResultPage addProductToCompare() {
        $("button.compare-button:not([class*=state_active])")
                .shouldBe(visible)
                .click();

        return this;
    }
}
