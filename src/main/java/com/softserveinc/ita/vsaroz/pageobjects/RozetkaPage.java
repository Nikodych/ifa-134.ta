package com.softserveinc.ita.vsaroz.pageobjects;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RozetkaPage {

    private final String categorySelector = "//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]";
    private final String laptopIconSelector = "//a[@title='Ноутбуки']";
    private final String brandFilterSelector = "//label[@for='Dell']";

    public void selectCategory() {
        $x(categorySelector).click();
    }

    public void activateLaptopFilter() {
        $x(laptopIconSelector).click();
    }

    public void filterByBrand(String producer) {
        $x(format("//a[@Class='checkbox-filter__link'][@href='/ua/notebooks/c80004/producer=%s/']", producer)).click();
    }

    public String getFilterName() {
        return $x(brandFilterSelector)
                .getText()
                .trim();
    }
}