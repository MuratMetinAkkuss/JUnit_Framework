package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitAnnotation {
    //bir class'da 3 farkli test olsa
    // ve ben testleri istersem toplu, istersem bagimsiz calistirabilsem
    /*
     Junit'in bize kazandirdigi en onemli yeniliklerden biri
     @Test annotation'dir

     Annotation kucuk bilgiler(meta data) barindiran yapilardir.
     sadece bir yazi ya da gosterim degillerdir
     yaptiklari islemler vardir

     @Test annotation siradan bir method'u tek basina calistirabilir
     bir test method'una donusturur

     JUnit ile test method'lari istersek tek basina istersek de class level'dan
     calistirilip tum testlerin birlikte calisabilecegi bir yapiya donusur

     JUnit class icerisindeki test method'larini belirsiz bir sirada calistirir
     nasil calistiracagini ongoremeyiz

     */


    @Test
    public void amazonTest(){
        //amazon'a gidelim ve url'in amazon icerdigini test edip sayfayi kapatalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("test passsed");
        }else {
            System.out.println("test failed");
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
        }

        driver.close();



    }

}
