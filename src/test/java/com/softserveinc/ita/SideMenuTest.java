package com.softserveinc.ita;

import com.softserveinc.ita.pageobjects.HomePage;
import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SideMenuTest extends TestRunner {

    private final HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] rozetkaCityData() {
        return new Object[][]{
                {"Харків"},
                {"Дніпро"}
        };
    }

    @Test(dataProvider = "rozetkaCityData")
    public void verifyCityChangingTest(String expectedCityName) {
        homePage
                .openSideMenu()
                .openCityModal()
                .changeWithPopularCity(expectedCityName)
                .submit();

        var actualCityName = homePage
                .openSideMenu()
                .getCityName();

        assertThat(actualCityName)
                .as("City should be changed")
                .contains(expectedCityName);
    }
}
