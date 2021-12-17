package com.softserveinc.ita.utils;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.Select;

@UtilityClass
public class ElementsUtil {

    public void setText(SelenideElement webElement, String text) {
        webElement.click();
        webElement.sendKeys(text);
    }

    public void selectOptionFromMenu(SelenideElement webElement , String text) {
        var value = new Select(webElement);
        value.selectByValue(text);
        webElement.click();
    }
}