package tests.day06_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_ {
     //1) Bir class oluşturun: YoutubeAssertions

     static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageElement = driver.findElement(By.xpath("(//a[@id='logo'])[1]"));
        Assert.assertTrue(imageElement.isDisplayed());

    }

    @Test
    public void searchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement boxElement = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(boxElement.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedWrongTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assert.assertNotEquals(expectedWrongTitle,actualTitle);

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
