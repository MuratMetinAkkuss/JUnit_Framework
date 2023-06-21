package tests.day07_testbase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_JsAlerts extends TestBase {
    /*
        bir testi calistirirken web sayfasi bize
        bir uyari verebilir
        eger,
        bu uyariyi inspect edebiliyorsak
        ve diger yum hyml Web elementler gibi
        locate edilebilir ve kullanilabilirler

        Ancak
        sag click yapip inspect edemiyorsak
        bunlar javascript alert olabilirler

        Js alert'ler locate edilemez
        sadece driver'larimizi i alert'lere switch yapipi
        o alert'lerde istenen islemleri yapabiliriz.
             */




    @Test
    public void test01(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin

            String expectedContent = "I am a JS Alert";
            String actualContent = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedContent,actualContent);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }
    @Test
    public void test02(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        Assert.assertEquals("You clicked: Cancel",driver.findElement(By.id("result")).getText());
    }

    @Test
    public void test03(){
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Abdullah"));

    }

}
