package com.softserveinc.ita.pageobjects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CityModal extends MenuModal {

    public CityModal changeCity(String title) {
        $x(format("//a[contains(@class, 'header-location__popular-link') and contains(text() , '%s')]", title)).click();

        return this;
    }

    public HomePage submit() {
        $x("//button[contains(@class, 'button button_size_medium')]").click();

        return new HomePage();
    }
}
