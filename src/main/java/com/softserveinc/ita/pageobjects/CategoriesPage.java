package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CategoriesPage extends BasePage<CategoriesPage>{

    private final String subCategorySelector = "(//a[contains(@class , 'tile-cats__heading')])[1]";
    private final String productSelector = "(//div[@class = 'goods-tile__inner'])[1]";
    private final String laptopsSubcategorySelector = "//a[@title='Ноутбуки']";

    public CategoriesPage openSubCategory() {
        $x(subCategorySelector).click();

        return this;
    }

    public CategoriesPage openProduct() {
        $x(productSelector).click();

        return this;
    }

    public CategoriesPage openLaptopsSubcategory() {
        $x(laptopsSubcategorySelector).click();

        return this;
    }

    public CategoriesPage filterByBrand(String producer) {
        $x(format("//a[@Class='checkbox-filter__link'][@href='/ua/notebooks/c80004/producer=%s/']", producer)).click();

        return this;
    }

    public CategoriesPage setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']").shouldBe(visible, ofSeconds(6));
        minPriceField.click();
        minPriceField.setValue(price);

        return this;
    }

    public CategoriesPage setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']").shouldBe(visible, ofSeconds(6));
        maxPriceField.click();
        maxPriceField.setValue(price);

        return this;
    }

    public CategoriesPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return this;
    }

    public CategoriesPage filterAvailableItems() {
        $x("//div[@data-filter-name='sell_status']//a//label[contains(text(), 'Є в наявності')]")
                .shouldBe(visible, ofSeconds(8))
                .click();

        return this;
    }
}