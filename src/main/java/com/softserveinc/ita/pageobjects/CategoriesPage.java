package com.softserveinc.ita.pageobjects;

import org.checkerframework.checker.units.qual.C;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CategoriesPage extends BasePage<CategoriesPage>{

    private final String subCategorySelector = "(//a[contains(@class , 'tile-cats__heading')])[1]";
    private final String productSelector = "(//div[@class = 'goods-tile__inner'])[1]";
    private final String laptopsSubcategorySelector = "//a[@title='Ноутбуки']";

    public CategoriesPage openSubCategory() {
        $x(subCategorySelector).click();

        return this;
    }

    public ProductPage openProduct() {
        $x(productSelector).click();

        return new ProductPage();
    }

    public CategoriesPage openLaptopsSubcategory() {
        $x(laptopsSubcategorySelector).click();

        return new CategoriesPage();
    }

    public CategoriesPage filterByBrand(String producer) {
        $x(format("//a[@Class='checkbox-filter__link'][@href='/ua/notebooks/c80004/producer=%s/']", producer)).click();

        return new CategoriesPage();
    }

    public CategoriesPage setMinimalPrice(String price) {
        var minPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='min']");
        minPriceField.click();
        minPriceField.setValue(price);

        return new CategoriesPage();
    }

    public CategoriesPage setMaximalPrice(String price) {
        var maxPriceField = $x("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid'][@formcontrolname='max']");
        maxPriceField.click();
        maxPriceField.setValue(price);

        return new CategoriesPage();
    }

    public CategoriesPage clickOnPriceButton() {
        $x("//button[@class='button button_color_gray button_size_small slider-filter__button']").click();

        return new CategoriesPage();
    }

    public CategoriesPage filterAvailableItems() {
        $x("//label[@for='Є в наявності']").click();

        return new CategoriesPage();
    }
}