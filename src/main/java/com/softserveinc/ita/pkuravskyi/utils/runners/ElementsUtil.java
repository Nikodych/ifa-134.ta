package com.softserveinc.ita.pkuravskyi.utils.runners;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner.*;
import static com.softserveinc.ita.pkuravskyi.utils.runners.TestRunner.defaultTimeout;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@UtilityClass
public class ElementsUtil {

    public static WebElement $x(By by) {
        return new WebDriverWait(getDriver(), defaultTimeout)
                .pollingEvery(Duration.ofSeconds(1))
                .until(presenceOfElementLocated(by));
    }

    // check if element's attribute contains something
    public static boolean $x(WebElement element, String attribute, String value) {
        return new WebDriverWait(getDriver(), defaultTimeout)
                .pollingEvery(Duration.ofSeconds(1))
                .until(attributeContains(element, attribute, value));
    }

    public static List<WebElement> $$x(By by) {
        return new WebDriverWait(getDriver(), defaultTimeout)
                .pollingEvery(Duration.ofSeconds(1))
                .until(visibilityOfAllElementsLocatedBy(by));
    }
}
