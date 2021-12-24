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
                {"Контакти", "Івано", 1, "Галицька, 94", "test",
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

        var soft = new SoftAssertions();
        soft.assertThat(wrongCity)
                .as("Test failed: the error message should appear when you enter wrong data")
                .contains(errorMessage);

        var actualCity = contactPage
                .fillCitySearchField(expectedCity)
                .getActualCity();

        soft.assertThat(actualCity)
                .as("Test failed: expected city should be: " + expectedCity)
                .anyMatch(city->city.contains(expectedCity));

        contactPage
                .selectRequiredCity(expectedCity)
                .selectShopFromSidebar(expectedOption);

        var actualPointOfDeliveryAddress = contactPage
                .showMoreTags()
                .clickOnExpectedCityTag(expectedCity)
                .getPointOfDeliveryAddressesList(expectedAddress);

        soft.assertThat(actualPointOfDeliveryAddress)
                .as("Test failed: actual point of delivery should be: " + expectedAddress)
                .anyMatch(address->address.contains(expectedAddress));
        soft.assertAll();
    }
}
