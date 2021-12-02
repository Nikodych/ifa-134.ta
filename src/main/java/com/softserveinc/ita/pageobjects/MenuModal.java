package com.softserveinc.ita.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MenuModal extends BasePage<MenuModal> {

    private final SelenideElement cityButton = $x("//button[contains(@class, 'city-toggle')]");

    @Step("MenuModal: open city modal window")
    public CityModal openCityModal() {
        cityButton.click();

        return new CityModal();
    }

    @Step("MenuModal: get city name")
    public String getCityName() {
        return cityButton
                .shouldBe(visible)
                .getText();
    }
}
