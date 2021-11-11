package com.softserveinc.ita.pkuravskyi.pageobjects;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SoftServePage {

    private final String sideNavBarCategoriesSelector = "//a[contains(@class, 'side-navigation__link')]";
    private final String activeSideNavBarCategorySelector = ".side-navigation__link_active div";
    private final String menuButtonSelector = "//button[@aria-label = 'Open menu']";
    private final String menuCategoriesSelector = "//ul[@class = 'main-navigation__menu']//a";
    private final String activeMenuCategorySelector = ".main-navigation__menu-opened a";

    public SoftServePage selectSideNavBarCategory(String category) {
        var sideNavBarItems = $$x(sideNavBarCategoriesSelector);

        for (var item : sideNavBarItems) {
            var itemAttribute = item
                    .getAttribute("text")
                    .substring(2);

            if (!itemAttribute.equals(category)) {
                continue;
            } else {
                item.click();
                //wait until selected item gets "active" class
                item.shouldHave(attributeMatching("className", ".*side-navigation__link_active.*"));
                break;
            }
        }

        return this;
    }

    public String getActiveSideNavBarCategory() {
        return $(activeSideNavBarCategorySelector).getAttribute("innerHTML");
    }

    public void openMenu() {
        $x(menuButtonSelector).click();
    }

    public SoftServePage selectMenuCategory(String category) {
        openMenu();

        var menuNavBarItems = $$x(menuCategoriesSelector);

        for (var item : menuNavBarItems) {
            var itemAttribute = item.getAttribute("textContent");

            if (!itemAttribute.equals(category)) {
                continue;
            } else {
                item.click();
                break;
            }
        }

        return this;
    }

    public String getActiveMenuUrl() {
        var list = new String[]{"resources", "blog", "locations", "contact"};

        for (var item : list) {
            if (url().contains(item)) {
                return url();
            }
        }

        return $x(activeMenuCategorySelector).getAttribute("href");
    }
}
