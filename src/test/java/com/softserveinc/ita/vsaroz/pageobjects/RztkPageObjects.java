package com.softserveinc.ita.vsaroz.pageobjects;

import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class RztkPageObjects {
    public WebDriver driver;

    private WebElement lapTops;
    private WebElement lapTopImg;
    private WebElement readyForOrder;

    public void getElements() {
        lapTops = driver.findElement(By.xpath("//a[@class='menu-categories__link js-menu-categories__link menu-categories__link_state_hovered']"));
        lapTopImg = driver.findElement(By.xpath("//img[@src='https://video.rozetka.com.ua/img_superportal/kompyutery_i_noutbuki/1.1.png']"));
        readyForOrder = driver.findElement(By.linkText(" Готовий до відправлення "));
    }
    public void findLapTop() {
        for (WebElement webElement : Arrays.asList(lapTops, lapTopImg, readyForOrder)) {
            webElement.click();
            return;
        }
    }
}