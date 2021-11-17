package com.softserveinc.ita.vsaroz.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.swing.*;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaPage {

    private final SelenideElement laptopMenuItemElement = $x("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]");
    private final SelenideElement laptopFilterCheckboxElement = $x("//a[@title='Ноутбуки']");
    private final List<SelenideElement> brandFilterCheckboxes = $$x("//div@class='sidebar-block__inner ng-star-inserted'");

    public void clickOnLaptopMenuItem() { laptopMenuItemElement.click(); }

    public void filterByLaptop() { laptopFilterCheckboxElement.click(); }

    public void filterByBrand(String id) {

    }


}
