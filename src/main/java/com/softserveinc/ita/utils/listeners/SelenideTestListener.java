package com.softserveinc.ita.utils.listeners;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestListener;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class SelenideTestListener implements ITestListener {

    static void setupAllureReports() {
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
                .afterEvent());
    }
}
