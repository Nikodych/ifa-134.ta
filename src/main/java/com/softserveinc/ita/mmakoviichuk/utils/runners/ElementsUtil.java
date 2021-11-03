package com.softserveinc.ita.mmakoviichuk.utils.runners;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.softserveinc.ita.mmakoviichuk.utils.runners.TestRunner.*;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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
