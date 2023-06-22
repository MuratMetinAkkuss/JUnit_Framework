package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeTest = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeTest);
        driver.findElement(By.tagName("p")).clear();
        driver.findElement(By.tagName("p")).sendKeys("Merhaba Dunya!");
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).getText());
    }
}
