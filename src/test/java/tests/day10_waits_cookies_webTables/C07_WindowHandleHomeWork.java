package tests.day10_waits_cookies_webTables;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C07_WindowHandleHomeWork extends TestBase {
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firstWH = driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"))).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        Set<String> WHSet = driver.getWindowHandles();
        for (String each:WHSet
             ) {
            if (!firstWH.equals(each)){
                driver.switchTo().window(each);
            }
        }
        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(faker.internet().password());
        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopText = "validation failed";
        String actualPopText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopText,actualPopText);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstWH);
        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertEquals(firstWH,driver.getWindowHandle());
        Assert.assertTrue(WHSet.contains(firstWH));

    }
}
