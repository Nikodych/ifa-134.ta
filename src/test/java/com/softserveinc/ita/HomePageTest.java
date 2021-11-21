package com.softserveinc.ita;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static com.softserveinc.ita.repos.CustomerOrderDataRepo.getCustomerOrderData;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

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
    public void verifyCheckoutPageFunctionalityTest() {
        homePage.closeAdBanner();
        var lastProductOfSection = homePage.getLastProductOfSection("Акційні пропозиції");

        assertThat(lastProductOfSection)
                .as("Last product of section should be opened")
                .isEqualTo(productPage.getProductName());

        productPage
                .addProductToBasket()
                .goToCheckout();

        checkoutPage.inputCustomerData();

        var expectedSurname = getCustomerOrderData().getSurname();
        assertThat(checkoutPage.getSurnameFieldText())
                .as("Surname should be '" + expectedSurname + "'")
                .isEqualTo(expectedSurname);

        var expectedName = getCustomerOrderData().getName();
        assertThat(checkoutPage.getNameFieldText())
                .as("Name should be '" + expectedName + "'")
                .isEqualTo(expectedName);

        var expectedPhoneNumber = "+38 " + getCustomerOrderData().getPhone();
        assertThat(checkoutPage.getPhoneFieldText())
                .as("Phone number should be '" + expectedPhoneNumber + "'")
                .isEqualTo(expectedPhoneNumber);

        var expectedCity = getCustomerOrderData().getCity();
        assertThat(checkoutPage.getCityFieldText())
                .as("City should be '" + expectedCity + "'")
                .contains(expectedCity);

        checkoutPage
                .editOrder()
                .addOneMoreProduct()
                .goToCheckout();

        var productAmountPrice = checkoutPage.getProductAmountPrice();
        assertThat(productAmountPrice)
                .as("Product amount price should be '" + productAmountPrice + "'")
                .isEqualTo(checkoutPage.getProductPrice() * checkoutPage.getProductCount());
    }
}
