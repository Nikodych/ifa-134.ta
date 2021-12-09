package com.softserveinc.ita.pageobjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.BrowserTabHelper.*;

public class HeaderMenuModal {

    @Step("HeaderMenuModal: Switched to second tab and got the title from PlayMarket. After - switched back to the first tab")
    public String getAndroidAppTitle() {
        switchToSecondWindow();
        var androidTitle = $x("//*[@class='AHFaub']//ancestor::span").getText();
        closeSecondAndSwitchToFirstWindow();

        return androidTitle;
    }

    @Step("HeaderMenuModal: Switched to second tab and got the title from AppStore. After - switched back to the first tab")
    public String getIosAppTitle() {
        switchToSecondWindow();
        var iosTitle = $x("//h1[@class='product-header__title app-header__title']").getText();
        closeSecondAndSwitchToFirstWindow();

        return iosTitle;
    }
}
