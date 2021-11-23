package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CheckoutPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.RU;
import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static com.softserveinc.ita.repos.CustomerOrderDataRepo.getCustomerOrderData;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    protected HomePage homePage = new HomePage();

    @Test
    public void verifyLanguageSwitchingTest() {
        var languageToSwitch = homePage.isLanguageSwitchedTo(UA) ? RU : UA;
        homePage.switchLanguageTo(languageToSwitch);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(languageToSwitch);

        assertThat(isLanguageSwitched)
                .as("Language should be switched to '" + languageToSwitch + "'")
                .isTrue();
    }

    protected ProductPage productPage = new ProductPage();
    protected CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyCheckoutPageFunctionalityTest() {
        homePage.closeAdBanner();
        var lastProductOfSection = homePage.getLastProductOfSection("Акційні пропозиції");

        assertThat(lastProductOfSection)
                .as("Last product of section should be opened")
                .isEqualTo(productPage.getProductName());

        productPage
                .addProductToBasket()
                .goToCheckout()
                .didCheckoutPageOpenCorrectly();

        checkoutPage.setCustomerData();

        var customerOrderData = getCustomerOrderData();
        var expectedSurname = customerOrderData.getSurname();
        assertThat(checkoutPage.getSurnameFieldText())
                .as("Surname should be '" + expectedSurname + "'")
                .isEqualTo(expectedSurname);

        var expectedName = customerOrderData.getName();
        assertThat(checkoutPage.getNameFieldText())
                .as("Name should be '" + expectedName + "'")
                .isEqualTo(expectedName);

        var expectedPhoneNumber = "+38 " + customerOrderData.getPhone();
        assertThat(checkoutPage.getPhoneFieldText())
                .as("Phone number should be '" + expectedPhoneNumber + "'")
                .isEqualTo(expectedPhoneNumber);

        var expectedCity = customerOrderData.getCity();
        assertThat(checkoutPage.getCityFieldText())
                .as("City should be '" + expectedCity + "'")
                .contains(expectedCity);

        checkoutPage
                .editOrder()
                .addOneMoreProduct()
                .goToCheckout()
                .didCheckoutPageOpenCorrectly();

        var productTotalPrice = checkoutPage.getProductTotalPrice();
        assertThat(productTotalPrice)
                .as("Product total price should be '" + productTotalPrice + "'")
                .isEqualTo(checkoutPage.getProductPrice() * checkoutPage.getProductQuantity());
    }
}
