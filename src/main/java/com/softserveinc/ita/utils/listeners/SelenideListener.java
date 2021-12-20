package com.softserveinc.ita.utils.listeners;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class SelenideListener {

    public void beforeTest() {
        SelenideLogger.addListener("Allure Selenide Listener",
                new AllureSelenide().savePageSource(true));
    }
}
