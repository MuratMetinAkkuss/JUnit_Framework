package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseQuit;

public class C07_MouseActions2 extends TestBaseQuit {
    @Test
    public void test01(){
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement aimedElement = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragMeElement,aimedElement).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String droppedString = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals("Dropped!",droppedString);

    }
}
