package tests.day05_maven_JUnitFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenFirstTest {

        /*
            Selenium 4.7.0 ile kendi webdriver'ini kullanma imkani verdi

            tum sirketler selenium webdriver'i kullanmaya izin vermeyebilir
            sirketlerde eskiden beri kullanilan bir web driver varsa
            onu projemize eklememiz ve kullanmamiz istenebilir

            boyle bir durumda istenen WebDriver'i
            pom.xml'e eklememiz istenebilir



         */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }
}
