package com.softserveinc.ita.vsaroz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class RegTest extends Data {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//vital//ifa-134.ta//src//test//java//com//softserveinc//ita//vsaroz//drivers//chromedriver_win32//chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private By Join = By.xpath("//a[@href='/join']");
    private By typeFirstName = By.id("user_first_name");
    private By typeLastName = By.id("user_last_name");
    private By typeEmail = By.id("user_email");
    private By typeUserName = By.id("user_username");
    private By typePassword = By.id("user_password");
    private By buttonJoin = By.xpath("//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']");

    @Test
    public void regTest() {
        driver.get(getUrl);
        driver.findElement(Join).click();
        driver.findElement(typeFirstName).sendKeys(firstName);
        driver.findElement(typeLastName).sendKeys(lastName);
        driver.findElement(typeEmail).sendKeys(email);
        driver.findElement(typeUserName).sendKeys(userName);
        driver.findElement(typePassword).sendKeys(password);
        driver.findElement(buttonJoin).click();
    }
}