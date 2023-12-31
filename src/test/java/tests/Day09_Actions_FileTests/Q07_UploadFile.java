package tests.Day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q07_UploadFile extends TestBase {
    @Test
    public void test01(){
        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        WebElement uploadFileElement = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.home")+"\\Downloads\\example.png";
        uploadFileElement.sendKeys(filePath);
        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());
    }
}
