package com.softserveinc.ita.vsaroz;

import com.softserveinc.ita.vsaroz.utils.runners.TestRunner;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RozetkaTest extends TestRunner {

    @Test
    public void verifyFilterFunctionality() {
        rozetkaPage.clickOnLaptopMenuItem();
        rozetkaPage.filterByLaptop();
        rozetkaPage.filterByBrand("Dell");
    }
}