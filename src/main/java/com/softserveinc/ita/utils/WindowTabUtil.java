package com.softserveinc.ita.utils;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.*;

@UtilityClass
public class WindowTabUtil {
    public static String getTitleFromSecondTab(SelenideElement selector) {
        switchTo().window(1);
        var title = selector.getText();
        closeWindow();
        switchTo().window(0);

        return title;
    }
}
