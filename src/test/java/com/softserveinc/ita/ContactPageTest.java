package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.ContactPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestRunner {

    @DataProvider
    public Object[][] contactPageData() {
        return new Object[][]{
                {"Контакти", "Івано-Франківськ", 1, "вул. Січових Стрільців, 68"}};
    }

    @Test(dataProvider = "contactPageData")
    public void verifyContactPageFunctionality(String expectedPage, String expectedCity, int expectedOption, String expectedAddress) {
        var homePage = new HomePage();
        homePage
                .closeAdvertisingBannerIfDisplayed()
                .openSidebarPage(expectedPage);

        var contactPage = new ContactPage();
        var actualCity = contactPage
                .fillCitySearchField(expectedCity)
                .getActualCity(expectedCity);

        var actualAddress = contactPage
                .selectRequiredCity(expectedCity)
                .selectShopFromSidebar(expectedOption)
                .getAddressList(expectedAddress);

        var actualPointOfDeliveryAddress = contactPage
                .clickOnExpectedCityTag(expectedCity)
                .getPointOfDeliveryAddressesList(expectedAddress);

        var soft = new SoftAssertions();
        soft.assertThat(actualCity)
                .as("Test failed: expected city should be: " + expectedCity)
                .contains(expectedCity);

        soft.assertThat(actualAddress)
                .as("Test failed: page should contain : " + expectedAddress + " address")
                .containsAnyOf(expectedAddress);

        soft.assertThat(actualPointOfDeliveryAddress.toString().trim())
                .as("Test failed: actual point of delivery should be: " + expectedAddress)
                .containsAnyOf(expectedAddress);
        soft.assertAll();
    }
}
