package com.softserveinc.ita.dkrutenko.utils.runners;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.softserveinc.ita.dkrutenko.utils.runners.TestRunner.*;
import static com.softserveinc.ita.dkrutenko.utils.runners.TestRunner.defaultTimeout;
import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

@UtilityClass
public class ElementsUtil {

    public static WebElement $x(By by) {
        try {
            return new WebDriverWait(getDriver(), defaultTimeout)
                    .pollingEvery(ofSeconds(1))
                    .until(visibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            throw new AssertionError(ex);
        }
    }

    public static List<WebElement> $$x(By by) {
        try {
            return new WebDriverWait(getDriver(), defaultTimeout)
                    .pollingEvery(ofSeconds(1))
                    .until(visibilityOfAllElementsLocatedBy(by));
        } catch (TimeoutException ex) {
            throw new AssertionError(ex);
        }
    }
}