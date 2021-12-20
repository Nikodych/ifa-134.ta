package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

public class SearchResultPage extends BasePage<SearchResultPage> {

    public List<String> getGoodsListByTitle(String productName) {
        return $$x("//*[@class='goods-tile__title']")
                .shouldBe(sizeGreaterThan(0), ofSeconds(8))
                .stream()
                .map(SelenideElement::getText)
                .filter(text -> text.contains(productName))
                .collect(toList());
    }

    @Step("SearchResultPage: Selected first item from product page")
    public ProductPage selectFirstItemFromProductPage() {
        $$x("//div[@class='goods-tile__inner']")
                .shouldHave(sizeNotEqual(0), ofSeconds(8))
                .stream()
                .findFirst()
                .get()
                .click();

        return new ProductPage();
    }

    @Step("SearchResultPage: Added product to compare")
    public SearchResultPage addProductToCompare() {
        $("button.compare-button:not([class*=state_active])")
                .shouldBe(visible)
                .click();

        return this;
    }

    public String getCurrentPriceFromFirstItem() {
        return $x("//li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }
}
