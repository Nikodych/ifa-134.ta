package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$$x;
import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class RozetkaPage extends BasePage<RozetkaPage> {

    private final By categoriesList = xpath("//a[@class = 'menu-categories__link']");
    private final By selectedCategory = xpath("//h1[@class = 'portal__heading ng-star-inserted']");
    private final By languageButtons = xpath("//ul[@class = 'lang-header lang ng-star-inserted']//li");

    public RozetkaPage() {
        searchBar = name("search");
        searchButton = xpath("//div[@class = 'header-search js-app-search-suggest']/form/button");
    }

    public RozetkaPage changeLanguage() {
        var languageElements = $$x(languageButtons);

        for (var listItem : languageElements) {
            var itemAttribute = listItem.getAttribute("className");

            if (itemAttribute.contains("lang-header__item_state_active")) {
                continue;
            } else {
                listItem.click();
                break;
            }
        }

        return this;
    }

    public RozetkaPage selectCategory(String categoryName) {
        var listOfCategories = $$x(categoriesList);

        for (var listItem : listOfCategories) {
            var itemAttribute = listItem.getAttribute("innerText");

            if (!itemAttribute.contains(categoryName)) {
                continue;
            } else {
                listItem.click();
                break;
            }
        }

        return this;
    }

    public String getSelectedCategoryName() {
        return $x(selectedCategory).getText();
    }
}
