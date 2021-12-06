package com.softserveinc.ita.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CityModal {

    @Step("CityModal: Changed with popular city '{title}'")
    public CityModal changeWithPopularCity(String title) {
        $x(format("//a[contains(@class, 'header-location__popular-link') and contains(text() , '%s')]", title)).click();

        return this;
    }

    @Step("CityModal: Clicked submit button")
    public HomePage submit() {
        $x("//button[contains(@class, 'button button_size_medium')]").click();

        return new HomePage();
    }
}
