package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage<ProductPage> {

    private final SelenideElement selectFromPriceModalMenuSelector = $("div > rz-sort > select");

    public ProductPage setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']");
        minPriceField.click();
        minPriceField.setValue(price);

        return this;
    }

    public ProductPage setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']");
        maxPriceField.click();
        maxPriceField.setValue(price);

        return this;
    }

    public ProductPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return this;
    }

    public ProductPage selectFromCheapToExpensive() {
        var selectCheap = selectFromPriceModalMenuSelector.should(Condition.appear);
        var index = new Select(selectCheap);
        index.selectByIndex(1);

        return this;
    }

    public ProductPage selectFromExpensiveToCheap() {
        var selectCheap = selectFromPriceModalMenuSelector.should(Condition.appear);
        var index = new Select(selectCheap);
        index.selectByIndex(2);

        return this;
    }

    public String getPriceFromFirstItem() {
        return $x("//ul[@class='catalog-grid ng-star-inserted']/li[1]//span[@class='goods-tile__price-value']")
                .shouldBe(visible, ofSeconds(12))
                .getText()
                .trim();
    }

    public BasketModal addToCart() {
        $x("//button[contains(@class,'buy-button button button_with_icon')]")
                .hover()
                .click();

        return new BasketModal();
    }

    public String getProductTitle() {
        return $x("//h1[@class='product__title']").getText();
    }

    public String getProductCategory() {
        return $x("//ul[@class='breadcrumbs ng-star-inserted']").getText();
    }
}
