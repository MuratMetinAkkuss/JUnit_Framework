package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseQuit;

import java.util.Set;

public class C05_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String wHDFirst = driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals("Opening a new window",driver.findElement(By.tagName("h3")).getText());
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> wHDPages =driver.getWindowHandles();
        for (String each:wHDPages
             ) {
            if (!wHDFirst.equals(each)){
                driver.switchTo().window(each);
            }
        }
        Assert.assertEquals("New Window",driver.getTitle());

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")).getText());
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(wHDFirst);
        Assert.assertEquals("The Internet",driver.getTitle());
    }
}
