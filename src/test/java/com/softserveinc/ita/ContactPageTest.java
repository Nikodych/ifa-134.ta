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
                {"Контакти", "Івано-Франківськ", 1, "Галицька, 94", "test",
                        "Город не найден. Проверьте написание или введите ближайший к вам!"}};
    }

    @Test(dataProvider = "contactPageData")
    public void verifyContactPageFunctionality(String expectedPage, String expectedCity, int expectedOption,
                                               String expectedAddress, String wrongData, String errorMessage) {
        var homePage = new HomePage();
        homePage
                .closeAdvertisingBannerIfDisplayed()
                .openSidebarPage(expectedPage);

        var contactPage = new ContactPage();
        var wrongCity = contactPage
                .fillCitySearchField(wrongData)
                .getErrorMessage();

        var actualCity = contactPage
                .fillCitySearchField(expectedCity)
                .getActualCity(expectedCity);

        contactPage
                .selectRequiredCity(expectedCity)
                .selectShopFromSidebar(expectedOption);

        var actualPointOfDeliveryAddress = contactPage
                .clickOnShowMoreTagsButton()
                .clickOnExpectedCityTag(expectedCity)
                .getPointOfDeliveryAddressesList(expectedAddress);

        var soft = new SoftAssertions();
        soft.assertThat(wrongCity)
                .as("Test failed: the error message should appear when you enter wrong data")
                .contains(errorMessage);

        soft.assertThat(actualCity)
                .as("Test failed: expected city should be: " + expectedCity)
                .contains(expectedCity);

        soft.assertThat(actualPointOfDeliveryAddress)
                .as("Test failed: actual point of delivery should be: " + expectedAddress)
                .contains(expectedAddress);
        soft.assertAll();
    }
}
