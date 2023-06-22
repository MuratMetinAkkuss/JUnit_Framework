package tests.day08_iFrame_windows_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_IFrame extends TestBase {
    @Test
    public void test01(){
        //cancelled test
        //1) /http://demo.guru99.com/test/guru99home sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameList = driver.findElements(By.tagName("//iframe"));
        System.out.println("iFrameList = " + iFrameList.size() + " numbers");
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        stop(5);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
    }
}
