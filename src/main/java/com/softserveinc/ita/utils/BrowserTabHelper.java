package com.softserveinc.ita.utils;

import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.*;

@UtilityClass
public class BrowserTabHelper {

    public static void switchToSecondWindow() {
        switchTo().window(1);
    }

    public static void closeSecondAndSwitchToFirstWindow() {
        closeWindow();
        switchTo().window(0);
    }
}
