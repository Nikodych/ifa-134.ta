package com.softserveinc.ita;

import com.softserveinc.ita.models.SocialMedia;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.BrowserTabHelper.*;
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

    @DataProvider
    public Object[][] rozetkaSocialMedia() {
        return new Object[][]{
                {"Facebook"},
                {"Telegram"}
        };
    }

    @Test(dataProvider = "rozetkaSocialMedia")
    public void verifySocialMediaLinks(String socialMediaName) {
        homePage.openSocialMediaPage(socialMediaName);
        var expectedUrl = SocialMedia.valueOf(socialMediaName.toUpperCase()).getSocialMediaLink();
        switchToTab(1);
        var actualUrl = getCurrentUrl();

        assertThat(expectedUrl)
                .as("Social media link should correspond " + socialMediaName)
                .contains(actualUrl);

        closeTab();
    }

    @Test
    public void verifyDiscountPrice() {
        var productPage = homePage
                .openDiscountCategory()
                .openProduct();

        var preDiscountPrice = productPage.getProductPriceBeforeDiscount();
        var currentPrice = productPage.getProductPrice();

        assertThat(currentPrice)
                .as("Price with discount should be lower than old price")
                .isLessThan(preDiscountPrice);
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
}
