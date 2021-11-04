package com.softserveinc.ita.dkrutenko.pageobjects.softserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$x;
import static com.softserveinc.ita.dkrutenko.utils.runners.ElementsUtil.$xc;
import static org.openqa.selenium.By.xpath;

public class BasePage {

    protected WebDriver driver;

    private final By cookieButtonSelector = xpath("//button[@class='cookie-message__cta-button']");
    private final By headerMenuContactUsButtonSelector = xpath("//button[@class='menu__contacts-button menu__contacts-button_black menu__contacts-button_black']");
    private final By headerMenuButtonSelector = xpath("//button[@class='menu__button menu__button_background_white']");
    private final By fullContactPageSelector = xpath("//a[@class='pop-up-form__external-link']");
    private final By languageSwitcherSelector = xpath("//li[@class='language-switcher__item']");
    private final By titleSelector = xpath("//p[@class='title__paragraph title__paragraph_listed smaller-font']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieMessageButton() {
        $xc(cookieButtonSelector).click();
    }

    public void clickHeaderContactsMenuButton() {
        $xc(headerMenuContactUsButtonSelector).click();
    }

    public void clickHeaderMenuButton() {
        $xc(headerMenuButtonSelector).click();
    }

    public void clickViewFullPage() {
        $xc(fullContactPageSelector).click();
    }

    public void clickLanguageSwitcher() {
        $xc(languageSwitcherSelector).click();
    }

    public String getTitle() {
        return $x(titleSelector).getText();
    }
}
