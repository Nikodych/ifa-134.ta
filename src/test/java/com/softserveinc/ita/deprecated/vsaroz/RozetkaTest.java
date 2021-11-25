package com.softserveinc.ita.deprecated.vsaroz;

import com.softserveinc.ita.deprecated.vsaroz.utils.runners.TestRunner;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {

    @Test
    public void verifyFilterFunctionality() {
        String brand = "dell";
        rozetkaPage.selectCategory();
        rozetkaPage.activateLaptopFilter();
        rozetkaPage.filterByBrand(brand);

        String brandName = rozetkaPage.getFilterName();

        assertThat(brandName)
                .as("Incorrect filter displayed")
                .isEqualTo("Dell");
    }
}