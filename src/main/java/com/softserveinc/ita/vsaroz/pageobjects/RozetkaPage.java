package com.softserveinc.ita.vsaroz.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RozetkaPage {
    protected WebDriver driver;

    private By lapTops = xpath("//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//li[1]");
    private By lapTopImg = xpath("//img[@src='https://video.rozetka.com.ua/img_superportal/kompyutery_i_noutbuki/1.1.png']");
    private By dell = xpath("//div[@class='sidebar-block ng-star-inserted']//li[4]");

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenuItem() {
        driver.findElement(lapTops).click();
        return;
        }

    public void clickLapTopImg() {
        driver.findElement(lapTopImg).click();
        return;
    }

    public void filterByBrand() {
        driver.findElement(dell).click();
        return;
    }
}