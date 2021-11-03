package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$$x;
import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$x;

import static org.openqa.selenium.By.xpath;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    private final By cookieButtonSelector = xpath("//button[@class='cookie-message__cta-button']");
    private final By menuButtonSelector = xpath("//button[@class='menu__button menu__button_background_white']");
    private final By languageSwitcherSelector = xpath("//li[@class='language-switcher__item']");
    private final By titleSelector = xpath("//p[@class='title__paragraph title__paragraph_listed smaller-font']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookieMessageButton() {
        $x(cookieButtonSelector).click();
    }

    public void clickMenuButton() {
        $x(menuButtonSelector).click();
    }

    public void clickLanguageSwitcher() {
        $x(languageSwitcherSelector).click();
    }

    public String getTitle() {
        return $x(titleSelector).getText();
    }
}
