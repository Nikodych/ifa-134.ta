package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CityModal extends MenuModal {

    public CityModal changeCity(String title) {
        String cityNameSelector = "//a[contains(@class, 'header-location__popular-link') and contains(text() , '%s')]";
        $x(format(cityNameSelector, title)).click();

        return this;
    }

    public HomePage submit() {
        String submitSelector = "//button[contains(@class, 'button button_size_medium')]";
        $x(submitSelector).click();

        return new HomePage();
    }
}
