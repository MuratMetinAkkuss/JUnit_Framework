package tests.day06_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Q01_ {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak

    //asagidaki testleri yapin

   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void bestBuyTest(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedURL ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualUrl);
    }
    @Test
    public void titleTest(){
        ////○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertNotEquals(expectedTitle,actualTitle);
    }

    @Test
    public void logoTest(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElement = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void FrancaisLinkTest(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElement = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisElement.isDisplayed());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
