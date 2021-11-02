package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftServeTest extends TestRunner {

    @Test
    public void verifySideNavBar() {
        softServePage.selectSideNavBarCategory("Events");
        Assert.assertEquals(softServePage.activeSideNavBarCategory(), "Events");
    }

    @Test
    public void verifyMenu() {
        softServePage.selectMenuCategory("Services");
        Assert.assertEquals(softServePage.activeMenuCategory(), "Services");
    }
}
