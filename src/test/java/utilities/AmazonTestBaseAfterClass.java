package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTestBaseAfterClass {
    protected static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    public void stop(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.out.println("Action STOPPED");
            throw new RuntimeException();
        }
    }

}
