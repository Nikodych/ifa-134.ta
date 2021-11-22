package com.softserveinc.ita.utils.runners;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class ElementsUtil {

    public void selectPriceFilterFromModalMenu(int value,String selector) {
        var selectCheap = $(selector);
        var index = new Select(selectCheap);
        index.selectByIndex(value);
    }
}
