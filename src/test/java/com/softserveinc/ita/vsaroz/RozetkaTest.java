package com.softserveinc.ita.vsaroz;

import com.softserveinc.ita.vsaroz.utils.runners.TestRunner;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {

    @Test
    public void verifyFilterFunctionality() {
        String brand = "dell";
        rozetkaPage.clickOnCategorySelector();
        rozetkaPage.clickOnCategory();
        rozetkaPage.filterByBrand(brand);

        String brandName = rozetkaPage
                .getFilterName()
                .trim();

        assertThat(brandName)
                .as("Incorrect filter displayed")
                .isEqualTo("Dell");
    }
}