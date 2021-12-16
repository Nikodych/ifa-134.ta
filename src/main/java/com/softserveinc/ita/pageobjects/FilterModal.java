package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.softserveinc.ita.models.ProductModel;
import io.qameta.allure.Step;

import java.util.logging.Filter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterModal extends BasePage<FilterModal> {

    private final SelenideElement selectFromPriceModalMenuSelector = $("div > rz-sort > select");

    @Step("FilterModal: Set minimal price to be '{price}'")
    public FilterModal setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']");
        minPriceField.click();
        minPriceField.setValue(price);

        return this;
    }

    @Step("FilterModal: Set maximal price to be '{price}'")
    public FilterModal setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']");
        maxPriceField.click();
        maxPriceField.setValue(price);

        return this;
    }

    @Step("FilterModal: Clicked on price button")
    public ProductPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return new ProductPage();
    }

    @Step("FilterModal: Selected from cheap to expensive")
    public FilterModal selectFromCheapToExpensive() {
        selectFromPriceModalMenuSelector
                .should(appear)
                .selectOption(1);

        return this;
    }

    @Step("FilterModal: Selected from expensive to cheap")
    public FilterModal selectFromExpensiveToCheap() {
        selectFromPriceModalMenuSelector
                .should(appear)
                .selectOption(2);

        return this;
    }
}
