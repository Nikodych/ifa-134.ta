package com.softserveinc.ita.vsaroz.pageobjects;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RozetkaPage {

    private final String categoryTypeSelector = "//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]";
    private final String laptopFilterCheckboxElement = "//a[@title='Ноутбуки']";
    private final String filteredCheckboxName = "//label[@for='Dell']";

    public void clickOnCategorySelector() {
        $x(categoryTypeSelector).click();
    }

    public void clickOnCategory() {
        $x(laptopFilterCheckboxElement).click();
    }

    public void filterByBrand(String producer) {
        $x(format("//a[@Class='checkbox-filter__link'][@href='/ua/notebooks/c80004/producer=%s/']", producer)).click();
    }

    public String getFilterName() {
        String name = $x(filteredCheckboxName).getText();
        return name;
    }
}