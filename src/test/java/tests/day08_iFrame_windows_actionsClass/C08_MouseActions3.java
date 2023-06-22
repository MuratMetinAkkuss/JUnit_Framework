package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseQuit;

public class C08_MouseActions3 extends TestBaseQuit {
    @Test
    public void test01(){
        //TEST WAS NOT UNDERSTOOD BY ME
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountListElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountListElement);
        //3- “Create a list” butonuna basin
        System.out.println(driver.findElement(By.xpath("//span[@class='nav-text']")).getText());
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourList = driver.findElement(By.xpath("//div[text()='Your Lists']"));
        //Assert.assertTrue(yourList.isDisplayed());
    }
}
