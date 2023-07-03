package tests.Day09_Actions_FileTests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Q01_Test extends TestBase {
    @Test
    public void test01(){
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();//for cookies
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        // i goonna create a accessing faker liberary for fake info
        Faker faker = new Faker();
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        String eMail = faker.internet().emailAddress();
        //7. Bir sifre girin

        //8. Tarih icin ay secin

        //9. Tarih icin gun secin

        //10. Tarih icin yil secin

        //11. Cinsiyeti secin
        actions.click(driver.findElement(By.xpath("//input[@name='firstname']"))).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("jan")
                .sendKeys(Keys.TAB)
                .sendKeys("4")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='-1']")).isSelected());
        //13. Sayfayi kapatin
    }
}
