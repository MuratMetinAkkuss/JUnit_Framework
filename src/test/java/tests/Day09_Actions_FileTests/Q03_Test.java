package tests.Day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class Q03_Test extends TestBase {
    @Test
    public void test01(){
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrameVideoElement = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iFrameVideoElement);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        //5- videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@title='Pause (k)']")).isEnabled());
    }
}
