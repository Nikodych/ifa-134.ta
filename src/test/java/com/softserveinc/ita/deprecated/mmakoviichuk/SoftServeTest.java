package com.softserveinc.ita.deprecated.mmakoviichuk;

import com.codeborne.selenide.Selenide;
import com.softserveinc.ita.deprecated.mmakoviichuk.pageobjects.softserve.SoftServePage;
import com.softserveinc.ita.deprecated.mmakoviichuk.utils.runners.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoftServeTest extends TestRunner {

    @BeforeMethod
    public void open() {
        Selenide.open("https://www.softserveinc.com/en-us");
    }

    @Test
    public void sidebarSingleClickTest() {
        var title = "Careers";
        SoftServePage softServePage = new SoftServePage();
        softServePage.switchSidebarSection(title);

        assertThat(softServePage.isSidebarSwitched(title))
                .as(title + " sidebar should be switched")
                .isTrue();
    }
}
