package com.softserveinc.ita.utils.runners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.OutputType.BYTES;

public class TestListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }
}
