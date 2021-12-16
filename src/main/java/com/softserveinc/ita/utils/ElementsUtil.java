package com.softserveinc.ita.utils;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.Select;

@UtilityClass
public class ElementsUtil {

    public SelenideElement setText(SelenideElement elementSelector, String text) {
        var input = elementSelector;
        input.click();
        input.sendKeys(text);

        return input;
    }

    public void selectModalMenu(SelenideElement selector , String text) {
        var selectForm = selector;
        var value = new Select(selectForm);
        value.selectByValue(text);
        selectForm.click();
    }
}