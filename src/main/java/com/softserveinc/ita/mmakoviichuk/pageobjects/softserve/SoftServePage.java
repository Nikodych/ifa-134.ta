package com.softserveinc.ita.mmakoviichuk.pageobjects.softserve;

import com.softserveinc.ita.mmakoviichuk.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SoftServePage extends BasePage {

    private List<WebElement> sidebar;

    public SoftServePage(WebDriver driver) {
        super(driver);
        sidebar = driver.findElements(By.xpath("//a[contains(@class, 'side-navigation__link')]"));
    }

    public void sidebarClick (int section) {
        sidebar.get(section).click();
        waitForAttributeChanges(sidebar.get(section), "class", "side-navigation__link_active");
        Assert.assertTrue(sidebar.get(section).getAttribute("class").contains("side-navigation__link_active"));
    }
}
