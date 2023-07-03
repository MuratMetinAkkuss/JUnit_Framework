package tests.Day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Q06_FileDownload extends TestBase {
    @Test
    public void test01(){
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. herhangibir.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='example.png']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home")+"\\Downloads\\example.png\\";
        Assert.assertTrue(Files.exists(Path.of(filePath)));
    }
}
