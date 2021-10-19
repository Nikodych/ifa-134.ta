package com.softserveinc.ita.mmakoviichuk;

import com.softserveinc.ita.models.TitleData;
import com.softserveinc.ita.pageobjects.SoftServePage;
import com.softserveinc.ita.utils.runners.SoftServeRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftServeTest extends SoftServeRunner {

    private TitleData titleData = TitleData.builder()
            .firstTitle("Home")
            .secondTitle("Careers")
            .thirdTitle("Learn with us")
            .fourthTitle("Focus on the future")
            .build();

    @Test
    public void sidebarTest()  {
        SoftServePage ssp = new SoftServePage(driver);
        ssp.sidebarOneClick(1);
        ssp.sidebarClick();
    }

    @Test
    public void checkTitle() {
        Assert.assertEquals(titleData, new SoftServePage(driver).getTitleData());
    }
}
