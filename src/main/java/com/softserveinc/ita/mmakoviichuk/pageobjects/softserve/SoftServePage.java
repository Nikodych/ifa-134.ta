package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SoftServePage extends BasePage {

    private WebElement sidebarSection;

    public SoftServePage(WebDriver driver) {
        super(driver);
    }

    public void sidebarClick (String section) {
        sidebarSection = driver.findElement(xpath(format("//a[div[@class = 'side-navigation__title' and text() = '%s']]", section)));
        sidebarSection.click();
    }

    public boolean isSidebarActive() {
        waitForAttributeChanges(
                sidebarSection,
                "class",
                "side-navigation__link_active");

        return sidebarSection.getAttribute("class").contains("side-navigation__link_active");
    }
}
