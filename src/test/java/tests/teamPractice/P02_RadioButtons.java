package tests.teamPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02_RadioButtons extends TestBase {
    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");
        //b. Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        stop(3);
        //c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement womenElement = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement manElemet = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customElement = driver.findElement(By.xpath("//input[@value='-1']"));

        manElemet.click();
        stop(2);
        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(manElemet.isSelected());
        Assert.assertFalse(womenElement.isSelected());
        Assert.assertFalse(customElement.isSelected());

    }
}
