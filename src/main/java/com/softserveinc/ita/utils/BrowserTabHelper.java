package com.softserveinc.ita.utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.*;

@UtilityClass
public class BrowserTabHelper {

    @Step("BrowserTabHelper: Switched to second tab")
    public static void switchToSecondWindow() {
        switchTo().window(1);
    }

    @Step("BrowserTabHelper: Closed current tab and switched back to the first tab")
    public static void closeSecondAndSwitchToFirstWindow() {
        closeWindow();
        switchTo().window(0);
    }
}
