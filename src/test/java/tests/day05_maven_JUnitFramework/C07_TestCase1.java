package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_TestCase1 {

    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6- Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8- Sayfayi kapatin

    WebDriver driver ;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    }
    @Test
    public void repeatTest(){
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";
        Assert.assertTrue(actualGoogleTitle.contains(expectedGoogleTitle));

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText()+ " result");

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin


    }

    @After
    public void teardown(){
        //8- Sayfayi kapatin
        driver.close();
    }
}
