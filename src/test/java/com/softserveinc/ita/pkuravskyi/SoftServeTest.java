package com.softserveinc.ita.pkuravskyi;

import com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftServeTest extends TestRunner {

    @Test
    public void verifySideNavBar() {
        softServePage.SideNavBar("Events");
        Assert.assertEquals(softServePage.ActiveSideNavBarLink(), "Events");
    }
}
