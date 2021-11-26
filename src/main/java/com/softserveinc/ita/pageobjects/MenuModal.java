package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MenuModal extends BasePage<MenuModal> {

    private final SelenideElement cityButton = $x("//button[contains(@class, 'city-toggle')]");

    public CityModal openCityModal() {
        cityButton.click();

        return new CityModal();
    }

    public String getCityName() {
        return cityButton
                .shouldBe(visible)
                .getText();
    }
}
