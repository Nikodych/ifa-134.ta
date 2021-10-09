package vsaroz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class firstTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C://Users//vital//Downloads//chromedriver_win32//chromedriver.exe");
    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    //Search by XPath and some selectors
    public void testMkt () throws InterruptedException {
        driver.get("http://mkt.uz.ua/");
        driver.findElement(By.xpath("//a[text()='Головна']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='btn btn-primary custom-button red-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("menu-item-15")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("info@mkt.uz.ua")).click();
        Thread.sleep(500);
    }


}
