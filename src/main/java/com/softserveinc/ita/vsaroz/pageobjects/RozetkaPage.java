package com.softserveinc.ita.vsaroz.pageobjects;

import static com.codeborne.selenide.Selenide.*;

public class RozetkaPage {

    private final String categoryTypeSelector = ("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]");
    private final String laptopFilterCheckboxElement = ("//a[@title='Ноутбуки']");
    private final String filteredCheckboxName = ("//label[@for='Dell']");

    public void clickOnCategorySelector() { $x(categoryTypeSelector).click(); }

    public void clickOnLaptopFilter() { $x(laptopFilterCheckboxElement).click(); }

    public void filterByBrand(String item) {
        $x("//a[@class='checkbox-filter__link']" + "[@href='/ua/notebooks/c80004/producer=" + item + "/']").click();
    }

    public void checkFilter() { $x(filteredCheckboxName).getText(); }
}
