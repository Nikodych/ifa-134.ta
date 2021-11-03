package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class SoftServePage extends BasePage {

    private final By sidebarElementsList = xpath("//a[contains(@class, 'side-navigation__link')]");

    public SoftServePage(WebDriver driver) {
        super(driver);
    }

    public void sidebarClick (int section) {
        driver.findElements(sidebarElementsList).get(section).click();
    }

    public boolean isSidebarActive(int section) {
        waitForAttributeChanges(driver.findElements(sidebarElementsList).get(section), "class", "side-navigation__link_active");

        return driver.findElements(sidebarElementsList).get(section).getAttribute("class").contains("side-navigation__link_active");
    }
}