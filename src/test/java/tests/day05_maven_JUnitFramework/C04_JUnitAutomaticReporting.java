package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JUnitAutomaticReporting {
    /*
        JUnit framework'unde
        bir class veya test method'u calistirildiginda
        JUnit tum class veya istenen method'un
        sorunsuz olarak sonuna kadar calisip calismadigini kontrol eder

        -sorunsuz claisirsa test passed
        -kodlar sorun ciktigi icin calistirilmazsa test FAILED
         olarak isaretlenir

         Eger if-else ile yaptigimiz testlerde
         JUnit'in raporlarinin da test sonuclari ile uyumlu olmasini isterseniz
         FAILED durumlaarinda throw keyword ile exception alabiliriz

     */

    @Test
    public void amazonTest(){
        //amazon'a gidelim ve url'in amazon icerdigini test edip sayfayi kapatalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
}
