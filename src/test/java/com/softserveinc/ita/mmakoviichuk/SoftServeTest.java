package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.mmakoviichuk.pageobjects.softserve.SoftServePage;
import com.softserveinc.ita.mmakoviichuk.runners.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoftServeTest extends TestRunner {

    @BeforeMethod
    public void open() {
        getDriver().get("https://www.softserveinc.com/en-us");
    }

    @Test
    public void sidebarSingleClick() {
        new SoftServePage(getDriver()).sidebarClick(2);
    }
}
