package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.softserve.SoftServePage;
import com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoftServeTest extends TestRunner {

    @BeforeMethod
    public void open() {
        getDriver().get("https://www.softserveinc.com/en-us");
    }

    @Test
    public void sidebarSingleClickTest() {
        SoftServePage softServePage = new SoftServePage(getDriver());
        softServePage.sidebarClick(2);
        Assert.assertTrue(softServePage.isSidebarActive(2));
    }
}
