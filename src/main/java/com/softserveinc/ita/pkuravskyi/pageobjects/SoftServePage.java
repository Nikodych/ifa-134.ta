package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;

import static com.softserveinc.ita.pkuravskyi.pageobjects.BasePage.getCurrentUrl;
import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$$x;
import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class SoftServePage {

    private final By sideNavBarCategoriesList = xpath("//a[contains(@class, 'side-navigation__link')]");
    private final By activeSideNavBarCategory = cssSelector(".side-navigation__link_active div");
    private final By menuButton = xpath("//button[@aria-label = 'Open menu']");
    private final By menuCategoriesList = xpath("//ul[@class = 'main-navigation__menu']//a");
    private final By activeMenuCategory = cssSelector(".main-navigation__menu-opened a");

    public SoftServePage selectSideNavBarCategory(String category) {
        var sideNavBarItems = $$x(sideNavBarCategoriesList);

        for (var item : sideNavBarItems) {
            var itemAttribute = item
                    .getAttribute("text")
                    .substring(2);

            if (!itemAttribute.equals(category)) {
                continue;
            } else {
                item.click();
                //wait until selected item gets "active" class
                $x(item, "className", "side-navigation__link_active");
                break;
            }
        }

        return this;
    }

    public String getActiveSideNavBarCategory() {
        return $x(activeSideNavBarCategory).getAttribute("innerHTML");
    }

    public void openMenu() {
        $x(menuButton).click();
    }

    public SoftServePage selectMenuCategory(String category) {
        openMenu();

        var menuNavBarItems = $$x(menuCategoriesList);

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
        var currentUrl = getCurrentUrl();
        var list = new String[]{"resources", "blog", "locations", "contact"};

        for (var item : list) {
            if (currentUrl.contains(item)) {
                return currentUrl;
            }
        }

        return $x(activeMenuCategory).getAttribute("href");
    }
}
