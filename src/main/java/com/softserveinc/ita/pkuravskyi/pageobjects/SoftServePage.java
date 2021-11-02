package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$$x;
import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.xpath;

public class SoftServePage {

    protected WebDriver driver;
    private final By sideNavBarCategoriesList = xpath("//a[contains(@class, 'side-navigation__link')]");
    private final By activeSideNavBarCategory = xpath("//a[contains(@class, 'side-navigation__link_active')]/div");
    private final By menuButton = xpath("//button[@aria-label = 'Open menu']");
    private final By menuCategoriesList = xpath("//ul[@class = 'main-navigation__menu']//a");
    private final By activeMenuCategory = xpath("//li[contains(@class,  'main-navigation__menu-opened')]");

    public SoftServePage(WebDriver driver) {
        this.driver = driver;
    }

    public SoftServePage selectSideNavBarCategory(String category) {
        var sideNavBarItems = $$x(sideNavBarCategoriesList);

        for (var item : sideNavBarItems) {
            if (!item
                    .getAttribute("text")
                    .substring(2)
                    .equals(category))
                continue;
            item.click();
            $x(item, "className", "side-navigation__link_active");
            break;
        }

        return this;
    }

    public String activeSideNavBarCategory() {
        return $x(activeSideNavBarCategory).getAttribute("innerHTML");
    }

    public void openMenu() {
        $x(menuButton).click();
    }

    public SoftServePage selectMenuCategory(String category) {
        openMenu();

        var menuNavBarItems = $$x(menuCategoriesList);

        for (var item : menuNavBarItems) {
            if (!item
                    .getAttribute("textContent")
                    .equals(category))
                continue;
            item.click();
            break;
        }
        return this;
    }

    public String activeMenuCategory() {
        return $x(activeMenuCategory).getAttribute("textContent");
    }
}
