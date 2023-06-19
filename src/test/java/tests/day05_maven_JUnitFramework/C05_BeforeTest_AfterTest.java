package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeTest_AfterTest {
    /*
        bir class'in icinde birden fazla
        test method'u varsa hepsi
        bagimisiz olarakta
        calistirabilsin diye
        default olarak ayar eklememiz gerekir
        ancak bu islem test method'larini gereksiz uzatir

        bunun yerine bir setup method'u olusturup ilgili ayarlari
        burada setup method'u icinde yapip
        test method'larinda sadece teste odaklanabiliriz

        bu yontem de scope'dan kaynaklanan WebDriver sorunu olusuur
        eger setup method'unda driver var ise bunu class
        level'a tasiyarak diger method'lardan da erisilebilir olmasini isteriz

     */
    WebDriver driver;
    @Test
    public void amazonTest(){
        //amazon'a gidelim ve url'in amazon icerdigini test edip sayfayi kapatalim
        setup();
        driver.get("https://www.amazon.com");

        String expectedUrl = "ramazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("test passsed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }

        driver.close();

    }

    @Test
    public void wisequarterTest(){
        //wise quarter anasayfaya gidip
        //title'in quarter iceridigini test edin
        //ve sayfayi kapatin

       setup();

        driver.get("https://www.wisequarter.com");

        String expectedTitle = "Wise Quarter";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }

        driver.close();



    }

    @Test
    public void youtubeTest(){
        setup();
        driver.get("https://www.youtube.com");

        //Title YouTube oldugunu test edin

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }
    }

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
