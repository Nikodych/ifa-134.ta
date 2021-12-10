package com.softserveinc.ita;

import com.softserveinc.ita.utils.runners.TestRunner;
import com.softserveinc.ita.pageobjects.*;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterFunctionalityTest extends TestRunner {

    private HomePage homePage = new HomePage();
    private CategoriesPage categoriesPage = new CategoriesPage();
    private ProductPage productPage = new ProductPage();
    private SearchResultPage searchResultPage = new SearchResultPage();

    @DataProvider
    public Object[][] filterOptions() {
        return new Object[][]{
                {"Ноутбуки та комп’ютери", 0, "lenovo", "10 000", "20 000", 0}};
    }

    @Test(dataProvider = "filterOptions")
    public void verifyFilterFunctionality(String category, int orderNumber, String brand, String minPrice, String maxPrice, int first) {

        homePage.openCategory(category);

        searchResultPage
                .openSubCategoryByOrderNumber(orderNumber)
                .filterByBrand(brand)
                .setMinimalPrice(minPrice.replaceAll("\\s", ""))
                .setMaximalPrice(maxPrice.replaceAll("\\s", ""))
                .clickOnPriceButton()
                .filterAvailableItems()
                .selectFirstItemFromProductPage();

        assertThat(productPage.getProductTitle())
                .as("Incorrect brand selected")
                .contains("Lenovo");

        assertThat(productPage.getProductPrice())
                .as("Select another price range")
                .isGreaterThanOrEqualTo(minPrice)
                .isLessThanOrEqualTo(maxPrice);
    }
}