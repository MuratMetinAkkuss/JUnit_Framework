package tests.day06_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButton {
    //a. Verilen web sayfasına gidin.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://facebook.com
        driver.get("https://facebook.com");
    }
    @Test
    public void facebookTest(){
        //b. Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
        //c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleElement = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleElement = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customElement = driver.findElement(By.xpath("//input[@value='-1']"));
        maleElement.click();

        //e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(maleElement.isSelected());
        Assert.assertFalse(femaleElement.isSelected());
        Assert.assertFalse(customElement.isSelected());

    }
    @Test
    public void teardown(){
        //driver.close();
    }
}
