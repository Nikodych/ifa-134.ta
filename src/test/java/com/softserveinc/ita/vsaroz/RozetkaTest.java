package com.softserveinc.ita.vsaroz;

import com.softserveinc.ita.utils.runners.TestRunner;
import com.softserveinc.ita.pageobjects.*;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {
    private HomePage homePage = new HomePage();
    private CategoriesPage categoriesPage = new CategoriesPage();
    private ProductPage productPage = new ProductPage();

    @DataProvider
    public Object[][] filterOptions() {
        return new Object[][]{
                {"Ноутбуки та комп’ютери", "lenovo", "5 000", "10 000"}};
    }

    @Test(dataProvider = "filterOptions")
    public void verifyFilterFunctionality(String category, String brand, String minPrice, String maxPrice) {

        homePage
                .openCategory(category)
                .openLaptopsSubcategory();

        categoriesPage
                .filterByBrand(brand)
                .setMinimalPrice(minPrice.replaceAll("\\s", ""))
                .setMaximalPrice(maxPrice.replaceAll("\\s", ""))
                .clickOnPriceButton()
                .filterAvailableItems();

        productPage.getFirstFilteredItem();

        assertThat(productPage.getProductTitle())
                .as("Incorrect brand selected")
                .contains("Lenovo");

        assertThat(productPage.getProductPrice())
                .as("Select correct price")
                .isGreaterThanOrEqualTo(minPrice);
                //.isLessThanOrEqualTo(maxPrice);

        assertThat(productPage.getItemStatus())
                .as("Item is unavailable for order")
                .isTrue();
    }
}