package com.softserveinc.ita.utils.listeners;

import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.*;

public class SelenideTestListener {

    static void setupAllureReports() {
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }
}
