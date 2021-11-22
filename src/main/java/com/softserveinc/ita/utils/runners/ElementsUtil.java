package com.softserveinc.ita.utils.runners;

import com.codeborne.selenide.Condition;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class ElementsUtil {

    public void selectPriceFilterFromModalMenu(int value,String selector) {
        var selectCheap = $(selector).should(Condition.appear);
        var index = new Select(selectCheap);
        index.selectByIndex(value);
    }
}
