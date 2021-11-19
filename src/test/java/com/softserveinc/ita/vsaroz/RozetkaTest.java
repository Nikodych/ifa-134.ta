package com.softserveinc.ita.vsaroz;

import com.softserveinc.ita.vsaroz.utils.runners.TestRunner;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {
    @DataProvider
    public Object[][] filterItems() {
        return new Object[][]{
                {"dell"}};
    }

    @Test(dataProvider = "filterItems")
    public void verifyFilterFunctionality(String brand) {
        rozetkaPage.clickOnCategorySelector();
        rozetkaPage.clickOnLaptopFilter();
        rozetkaPage.filterByBrand(brand);
        rozetkaPage.checkFilter();

        assertThat(brand)
                .as("Incorrect filter displayed")
                .isEqualTo("dell");

    }
}