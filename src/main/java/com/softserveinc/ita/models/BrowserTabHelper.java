package com.softserveinc.ita.models;

import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

@UtilityClass
public class BrowserTabHelper {

    public void switchToTab(int tabNumber) {
        switchTo().window(tabNumber);
    }

    public String getCurrentUrl() {
        return url();
    }

    public void closeTab() {
        closeWindow();
    }
}
