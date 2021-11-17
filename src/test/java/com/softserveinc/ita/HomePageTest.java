package com.softserveinc.ita;

import com.softserveinc.ita.utils.runners.TestRunner;
import org.testng.annotations.Test;

import static com.softserveinc.ita.models.LanguageSwitcher.UA;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends TestRunner {

    @Test
    public void verifyLanguageIsSwitchingTest() {
        homePage.switchLanguageTo(UA);
        var isLanguageSwitched = homePage.isLanguageSwitchedTo(UA);
        assertThat(isLanguageSwitched)
                .as("Language should be switched")
                .isEqualTo(true);
    }
}
