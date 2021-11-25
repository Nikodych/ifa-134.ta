package com.softserveinc.ita.deprecated.pkuravskyi;

import com.softserveinc.ita.deprecated.pkuravskyi.pageobjects.SoftServePage;
import com.softserveinc.ita.deprecated.pkuravskyi.utils.runners.TestRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class SoftServeTest extends TestRunner {

    @BeforeClass
    public void setUpTest() {
        homePage = "https://www.softserveinc.com/en-us";
        softServePage = new SoftServePage();
    }

    @DataProvider
    public Object[][] sideNavBarCategories() {
        return new Object[][]{
                {"Home"}, {"Careers"}, {"Learn with Us"}, {"Focus on the Future"}, {"Services"},
                {"COVID-19 Solutions"}, {"Your Digital Journey"}, {"Our Partners"}, {"Industries"},
                {"Client testimonials"}, {"Our Customers"}, {"Events"}, {"Insights"}, {"Contact Us"}};
    }

    @Test(dataProvider = "sideNavBarCategories")
    public void verifySideNavBarTest(String category) {
        softServePage.selectSideNavBarCategory(category);
        var activeSideNavBarCategory = softServePage.getActiveSideNavBarCategory();
        assertThat(activeSideNavBarCategory)
                .as("Category name should be correct")
                .contains(category);
    }

    @DataProvider
    public Object[][] menuCategories() {
        return new Object[][]{
                {"Your Digital Journey", "https://www.softserveinc.com/en-us/your-journey/reveal"},
                {"Industries", "https://www.softserveinc.com/en-us/industries"},
                {"Services", "https://www.softserveinc.com/en-us/services"},
                {"Resources", "https://www.softserveinc.com/en-us/resources"},
                {"News & Events", "https://www.softserveinc.com/en-us/news"},
                {"Careers", "https://career.softserveinc.com/en-us/careers"},
                {"About us", "https://www.softserveinc.com/en-us/about-us"},
                {"Our Partners", "https://www.softserveinc.com/en-us/our-partners"},
                {"University", "https://career.softserveinc.com/en-us/university"},
                {"Social Responsibility", "https://www.softserveinc.com/en-us/corporate-social-responsibility"},
                {"Blog", "https://www.softserveinc.com/en-us/blog"},
                {"Locations", "https://www.softserveinc.com/en-us/locations"},
                {"Contact", "https://www.softserveinc.com/en-us/contact"}};
    }

    @Test(dataProvider = "menuCategories")
    public void verifyMenuTest(String category, String expectedUrl) {
        softServePage.selectMenuCategory(category);
        var activeMenuUrl = softServePage.getActiveMenuUrl();
        assertThat(activeMenuUrl)
                .as("Category name should be correct")
                .contains(expectedUrl);
    }
}
