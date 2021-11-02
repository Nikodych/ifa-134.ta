package com.softserveinc.ita.pkuravskyi.pageobjects;

import org.openqa.selenium.By;

import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$$x;
import static com.softserveinc.ita.pkuravskyi.utils.runners.ElementsUtil.$x;
import static org.openqa.selenium.By.xpath;

public class SoftServePage {

    private final By sideNavBarList = xpath("//a[contains(@class, 'side-navigation__link')]");
    private final By activeSideNavBarItem = xpath("//a[contains(@class, 'side-navigation__link_active')]/div");

    public SoftServePage SideNavBar(String category) {
        var sideNavBarItems = $$x(sideNavBarList);

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

    public String ActiveSideNavBarLink() {
        return $x(activeSideNavBarItem).getAttribute("innerHTML");
    }
}
