package tests.teamPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P06_IFrame extends TestBase {
    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
       // WebElement cookiesElement = driver.findElement(By.xpath("//span[text()='Accept All']"));
       // if (cookiesElement.isDisplayed()){
       //     cookiesElement.click();
       // }else {
       //     System.out.println("cookies gozukmedi");
       // }
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameElement = driver.findElements(By.tagName("iframe"));
        System.out.println("iFrameElement.size() = " + iFrameElement.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement secondIFrameElement = driver.findElement(By.id("a077aa5e"));
        secondIFrameElement.click();

    }
}
