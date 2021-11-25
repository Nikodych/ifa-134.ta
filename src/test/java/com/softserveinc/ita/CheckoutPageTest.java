package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.CheckoutPage;
import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.pageobjects.ProductPage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static com.softserveinc.ita.repos.CustomerOrderDataRepo.getCustomerOrderData;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutPageTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @Test
    public void verifyCheckoutPageFunctionalityTest() {
        var testSectionName = "Акційні пропозиції";

        homePage.closeAdBanner();

        var lastProductOfSection = homePage.getLastProductTitleOfSection(testSectionName);

        var productPage = homePage.openLastProductOfSection(testSectionName);

        assertThat(productPage.getProductTitle())
                .as("Last product of section " + testSectionName + " should be opened")
                .isEqualTo(lastProductOfSection);

        productPage
                .addToCart()
                .goToCheckout();

        var checkoutPage = new CheckoutPage();
        var customerOrderData = getCustomerOrderData();

        checkoutPage.setCustomerData(customerOrderData);

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
                .goToCheckout();

        var productTotalPrice = checkoutPage.getProductTotalPrice();
        assertThat(productTotalPrice)
                .as("Product total price should be '" + productTotalPrice + "'")
                .isEqualTo(checkoutPage.getProductPrice() * checkoutPage.getProductQuantity());
    }
}
