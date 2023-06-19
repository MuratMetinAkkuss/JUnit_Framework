package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeTest_AfterTest_Annotations {
    /*
        Junit ile class'daki her test method'u calismaya baslamadan once
        calismasini istedigimiz methodlari @Before,

        her test method'undan sonra calismasini istedgimiz method'lari ise
        @After annotation ile isaretleriz

        boylece test method'u calismaya baslarken
        ekstradan methodCall yapmaya gerek olmadan
        @Before annotation ile method'u calistirirz

        Test method'u bitince de hic bir method call olmaksizin
        @After annotation method'una sahip method calisir

        bu class level'dan calistirildiginda
        class'daki method'lar toplam kac kere calismis oldu

        @Before
        amazon
        @After
        @Before
        wisequarter
        @After
        @Before
        youtube
        @After

        Sadece youtube method'unu calistirmak istersek bile 3 method calisir


     */
    WebDriver driver;
    @Test
    public void amazonTest(){
        //amazon'a gidelim ve url'in amazon icerdigini test edip sayfayi kapatalim

        driver.get("https://www.amazon.com");

        String expectedUrl = "ramazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("test passsed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }
    }

    @Test
    public void wisequarterTest(){
        //wise quarter anasayfaya gidip
        //title'in quarter iceridigini test edin
        //ve sayfayi kapatin



        driver.get("https://www.wisequarter.com");

        String expectedTitle = "Wise Quarter";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
            throw new RuntimeException();
        }
    }

    @Test
    public void youtubeTest(){

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

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }
}
