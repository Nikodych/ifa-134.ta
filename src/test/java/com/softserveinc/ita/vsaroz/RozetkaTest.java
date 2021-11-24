package com.softserveinc.ita.vsaroz;

import com.softserveinc.ita.utils.runners.TestRunner;
import com.softserveinc.ita.pageobjects.*;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {
    private HomePage homePage = new HomePage();
    private CategoriesPage categoriesPage = new CategoriesPage();
    private ProductPage productPage = new ProductPage();

    @Test
    public void verifyFilterFunctionality() {
       var category = "Ноутбуки та комп’ютери";
       var brand = "lenovo";
       var minPrice = "5 000";
       var maxPrice = "10 000";

        homePage
                .openCategory(category)
                .openLaptopsSubcategory();

        var SubcategoryName = $x("//h1[@class='catalog-heading ng-star-inserted']")
                .getText()
                .trim();

        assertThat(SubcategoryName)
                .as("Select another category")
                .isEqualTo("Ноутбуки");

        categoriesPage
                .filterByBrand(brand)
                .setMinimalPrice(minPrice.replaceAll(" ", ""))
                .setMaximalPrice(maxPrice.replaceAll(" ", ""))
                .clickOnPriceButton()
                .filterAvailableItems();

        productPage.getFirstFilteredItem();

        assertThat(productPage.getProductTitle())
                .as("Incorrect brand selected")
                .contains("Lenovo");

        assertThat(productPage.getProductPrice())
                .as("Select greater price")
                .isGreaterThanOrEqualTo(minPrice)
                .isLessThanOrEqualTo(maxPrice);

        assertThat(productPage.getItemStatus())
                .as("Item is unavailable for order")
                .isTrue();
    }
}