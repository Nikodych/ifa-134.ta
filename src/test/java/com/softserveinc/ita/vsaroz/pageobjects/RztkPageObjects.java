package com.softserveinc.ita.vsaroz.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class RztkPageObjects {
   public WebDriver driver;

    private WebElement homePage;
    private WebElement lapTops;
    private WebElement lapTopImg;
    private WebElement readyForOrder;

    public void MainElements() {
        homePage = driver.findElement(By.xpath("//img[@src='https://xl-static.rozetka.com.ua/assets/img/design/logo_n.svg']"));
        lapTops = driver.findElement(By.xpath("//a[@class='menu-categories__link js-menu-categories__link menu-categories__link_state_hovered']"));
        lapTopImg = driver.findElement(By.xpath("//img[@src='https://video.rozetka.com.ua/img_superportal/kompyutery_i_noutbuki/1.1.png']"));
        readyForOrder = driver.findElement(By.linkText(" Готовий до відправлення "));
    }

    public void homePageClick() {
        homePage.click();
    }

    public void goLapTops() {
        lapTops.click();
    }

    public void lapTopsImgClick() {
        lapTopImg.click();
    }

    public void readyForOrderButton() {
        readyForOrder.click();
    }
}
