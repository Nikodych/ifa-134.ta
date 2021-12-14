package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

public class ProductModel extends BasePage<ProductModel> {

    public List<String> getGoodsListByTitle(String productName) {
        return $$x("//*[@class='goods-tile__title']")
                .shouldBe(sizeGreaterThan(0), ofSeconds(8))
                .stream()
                .map(SelenideElement::getText)
                .filter(text -> text.contains(productName))
                .collect(toList());
    }

    public String getCurrentPriceFromFirstItem() {
        return $x("//li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public String getOldPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//div[@class='goods-tile__price--old price--gray ng-star-inserted']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public String getNumberOfReviewsFromItemBy(String itemNumber) {
        return $x("//li[" + itemNumber + "]//div[@class='goods-tile__stars ng-star-inserted']/*[name() = 'svg']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    @Step("ProductModel: Click on 'add to cart' button on first product")
    public ProductModel addProductToCartBy(String itemNumber) {
        $x("//li[" + itemNumber + "]//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
                .shouldBe(visible, ofSeconds(12))
                .click();

        return this;
    }
}
