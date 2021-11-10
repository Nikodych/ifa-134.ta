package com.softserveinc.ita.vsaroz.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RozetkaPage {

    private final SelenideElement lapTops = $x("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]");
    private final SelenideElement filterByLapTop = $x("//a[@title='Ноутбуки']");
    private final SelenideElement dell = $x("//div[@class='sidebar-block ng-star-inserted']//li[4]");

    public void clickOnMenuItem() { $(lapTops).click(); }

    public void clickLapTop() { $(filterByLapTop).click(); }

    public void filterByBrand() { $(dell).shouldHave(Condition.text("Dell")).click(); }
}
