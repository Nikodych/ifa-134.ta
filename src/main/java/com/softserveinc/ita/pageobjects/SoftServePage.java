package com.softserveinc.ita.pageobjects;

import com.softserveinc.ita.models.TitleData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SoftServePage {

    protected WebDriver driver;
    private List<WebElement> sidebar;
    private List<WebElement> titles;

    public SoftServePage(WebDriver driver) {
        this.driver = driver;
        sidebar = driver.findElements(By.xpath("//li[contains(@class, 'side-navigation__item')]"));
        titles = driver.findElements(By.xpath("//div[contains(@class, 'side-navigation__title')]"));
    }

    public void sidebarClick () {
        driver.manage().window().maximize();
        for (WebElement section : sidebar) {
            section.click();
        }
    }
    public void sidebarOneClick (int section) {
        driver.manage().window().maximize();
        sidebar.get(section).click();
    }

    public TitleData getTitleData() {
        var first = "Home";
        var second = "Careers";
        var third = "Learn with us";
        var fourth = "Focus on the future";

        return TitleData.builder()
                .firstTitle(first)
                .secondTitle(second)
                .thirdTitle(third)
                .fourthTitle(fourth)
                .build();
    }

    public String getFirstTitle() {
        return titles.get(0).getText();
    }
    public String getSecondTitle() {
        return titles.get(1).getText();
    }
    public String getFThirdTitle() {
        return titles.get(2).getText();
    }
    public String getFourthTitle() {
        return titles.get(3).getText();
    }
}
