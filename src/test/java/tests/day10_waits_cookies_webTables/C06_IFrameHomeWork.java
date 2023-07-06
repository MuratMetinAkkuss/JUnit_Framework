package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_IFrameHomeWork extends TestBase {
    @Test
    public void test01(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        String firsPageWH = driver.getWindowHandle();
        //2. “Our Products” butonuna basin
        WebElement iFrameElement = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iFrameElement);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("(//*[@href='#'])[2]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.findElement(By.className("modal-body")).getText());
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']")).click();
        String secondPageWH = driver.getWindowHandle();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']")).isDisplayed());
    }
}
