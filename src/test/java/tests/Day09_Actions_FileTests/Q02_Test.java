package tests.Day09_Actions_FileTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q02_Test extends TestBase {
    @Test
    public void test01(){
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"))).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//p[text()='Click and Hold!']"))).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")));
        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.id("double-click"))).perform();
    }
}
