package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.runners.ElementsUtil.*;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage<ProductPage> {

    private final String selectFromPriceModalMenuSelector = "div > rz-sort > select";

    public ProductPage setMinimalPrice(String price) {
        setPriceValueInFilter("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']", price);

        return this;
    }

    public ProductPage setMaximalPrice(String price) {
        setPriceValueInFilter("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']", price);

        return this;
    }

    public String getPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public ProductPage selectFromCheapToExpensive() {
        selectPriceFilterFromModalMenu(1, selectFromPriceModalMenuSelector);

        return this;
    }

    public ProductPage selectFromExpensiveToCheap() {
        selectPriceFilterFromModalMenu(2, selectFromPriceModalMenuSelector);

        return this;
    }

    public ProductPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return this;
    }
}
