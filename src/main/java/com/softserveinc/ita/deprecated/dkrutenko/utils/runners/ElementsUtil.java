package com.softserveinc.ita.deprecated.dkrutenko.utils.runners;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.$x;

@UtilityClass
public class ElementsUtil {

    public SelenideElement setText(String elementSelector, String text) {
        var input = $x(elementSelector);
        input.click();
        input.sendKeys(text);

        return input;
    }
}
