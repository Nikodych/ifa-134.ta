package com.softserveinc.ita.mmakoviichuk;

import com.codeborne.selenide.Selenide;
import com.softserveinc.ita.mmakoviichuk.pageobjects.softserve.SoftServePage;
import com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoftServeTest extends TestRunner {

    @BeforeMethod
    public void open() {
        Selenide.open("https://www.softserveinc.com/en-us");
    }

    @Test
    public void sidebarSingleClickTest() {
        SoftServePage softServePage = new SoftServePage();
        softServePage.switchSidebarSection("Careers");

        Assert.assertTrue(softServePage.isSidebarSwitched("Careers"));
    }
}
