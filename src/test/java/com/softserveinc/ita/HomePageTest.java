package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.VacancyPage;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.repos.VacancyUserRepo.getVacancyUser;
import static com.softserveinc.ita.utils.BrowserTabHelper.*;
import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static com.softserveinc.ita.models.SocialMedia.getSocialMediaLinkBy;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] rozetkaCategoryData() {
        return new Object[][]{
                {"Товари для геймерів"}
        };
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionTest(String title) {
        var actualTitle = homePage
                .openCategory(title)
                .openSubCategory()
                .openProduct()
                .getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @Test(dataProvider = "rozetkaCategoryData")
    public void verifyCategoryTransitionThroughDropdownTest(String title) {
        var actualTitle = homePage
                .openCatalog()
                .openDropdownCategory(title)
                .openSubCategory()
                .openProduct()
                .getProductCategory();

        assertThat(actualTitle)
                .as("Product should correspond " + title + " category")
                .contains(title);
    }

    @DataProvider
    public Object[][] rozetkaSocialMedia() {
        return new Object[][]{
                {"Facebook"},
                {"Telegram"}
        };
    }

    @Test(dataProvider = "rozetkaSocialMedia")
    public void verifySocialMediaLinks(String socialMediaName) {
        var expectedUrl = getSocialMediaLinkBy(socialMediaName);

        homePage.openSocialMediaPage(socialMediaName);
        switchToTab(1);
        var actualUrl = getCurrentUrl();

        assertThat(expectedUrl)
                .as("Social media link should correspond " + socialMediaName)
                .contains(actualUrl);

        closeTab();
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

    @Test
    public void verifyOpeningMobileAppLinksTest() {
        var playMarketLink = "Google Play";
        var appStoreLink = "AppStore";
        var appTitle = "ROZETKA";

        var rozetkaPlayMarketTitle = homePage
                .closeAdvertisingBannerIfDisplayed()
                .clickOnHeaderMenuButton()
                .selectMobileAppLink(playMarketLink)
                .getAndroidAppTitle();

        assertThat(rozetkaPlayMarketTitle)
                .as("Test failed: Required app should be: " + appTitle)
                .contains(appTitle);

        var rozetkaAppStoreTitle = homePage
                .selectMobileAppLink(appStoreLink)
                .getIosAppTitle();

        assertThat(rozetkaAppStoreTitle)
                .as("Test failed: Required app should be: " + appTitle)
                .contains(appTitle);
    }


    @DataProvider
    public Object[][] vacancyPageData() {
        return new Object[][]{
                {"Вакансії", "dospecwork@gmail.com", "QA engineers"}
        };
    }

    @Test(dataProvider = "vacancyPageData")
    public void verifyVacancyPageFunctionality(String expectedPage, String expectedEmail, String expectedCategory) {
        homePage
                .closeAdvertisingBannerIfDisplayed()
                .openSidebarPage(expectedPage);

        var vacancyPage = new VacancyPage();
        var user = getVacancyUser();
        vacancyPage
                .selectRandomCategory()
                .clickOnSendDataButton()
                .fillVacancyPageFields(user)
                .selectCategoryAndDepartament(user);

        var currentEmail = vacancyPage.getAttributeFromEmailField();
        assertThat(currentEmail)
                .as("Test failed: Current email should be: " + expectedEmail)
                .isEqualTo(expectedEmail);

        var currentCategory = vacancyPage.getTextFromCategoryModal();
        assertThat(currentCategory)
                .as("Test failed: Current category should be :" + expectedCategory)
                .isEqualTo(expectedCategory);
    }
}
