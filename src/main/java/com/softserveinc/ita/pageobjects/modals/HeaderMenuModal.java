package com.softserveinc.ita.pageobjects.modals;

import static com.codeborne.selenide.Selenide.$x;
import static com.softserveinc.ita.utils.BrowserTabHelper.closeSecondAndSwitchToFirstWindow;
import static com.softserveinc.ita.utils.BrowserTabHelper.switchToSecondWindow;

public class HeaderMenuModal {

    public String getAndroidAppTitle() {
        switchToSecondWindow();
        var androidTitle = $x("//*[@class='AHFaub']//ancestor::span").getText();
        closeSecondAndSwitchToFirstWindow();

        return androidTitle;
    }

    public String getIosAppTitle() {
        switchToSecondWindow();
        var iosTitle = $x("//h1[@class='product-header__title app-header__title']").getText();
        closeSecondAndSwitchToFirstWindow();

        return iosTitle;
    }
}
