package com.softserveinc.ita;

import com.codeborne.selenide.Selenide;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"},
                {"Побутова техніка"}
        };
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionTest(String title) {
        homePage
                .openCategory(title)
                .openSubCategory()
                .openProduct();

        var actualTitle = new ProductPage().getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionThroughDropdownTest(String title) {
        homePage
                .openCatalog()
                .openDropdownCategory(title)
                .openSubCategory()
                .openProduct();

        var actualTitle = new ProductPage().getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @Test
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched to '" + languageToSwitch + "'")
                .isTrue();
    }

    @DataProvider
    public Object[][] mobileAppLinks() {
        return new Object[][]{
                {"Google Play", "AppStore", "ROZETKA"}};
    }

    @Test(dataProvider = "mobileAppLinks")
    public void verifyOpeningMobileAppLinksTest(String playMarketLink, String appStoreLink, String appTitle) {
        var rozetkaPlayMarketTitle = homePage
                .closeAdvertisingBannerIfDisplayed()
                .clickOnHeaderMenuButton()
                .selectMobileAppLink(playMarketLink)
                .getTitleFromGooglePlayApp();

        switchTo().window(0);
//        assertThat(rozetkaPlayMarketTitle)
//                .as("Test failed: Required app should be: " + appTitle)
//                .contains(appTitle);

        var rozetkaAppStoreTitle = homePage
                .selectMobileAppLink(appStoreLink);
                //.getTitleFromAppStore();

//        assertThat(rozetkaAppStoreTitle)
//                .as("Test failed: Required app should be: " + appTitle)
//                .contains(appTitle);
    }
}
