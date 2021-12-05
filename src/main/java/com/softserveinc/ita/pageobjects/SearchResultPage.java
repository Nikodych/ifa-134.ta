package com.softserveinc.ita.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class SearchResultPage extends BasePage<SearchResultPage> {

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
}
