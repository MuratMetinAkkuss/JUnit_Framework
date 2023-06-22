package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C06_MouseActions1 extends TestBaseQuit {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String wHDFirst = driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement dashedLineElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(dashedLineElement).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        String wHDSecondPage = ReusableMethods.WindowHandleForPages(wHDFirst,driver);
        driver.switchTo().window(wHDSecondPage);
        Assert.assertEquals("Make sure your code lands",driver.findElement(By.xpath("//h1[text()='Make sure your code lands']")).getText());

    }
}
