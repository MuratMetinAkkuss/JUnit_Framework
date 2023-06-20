package tests.day06_TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_CheckBox {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void boxTest(){
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cBoxElement1 = driver.findElement(By.xpath("//form[text()=' checkbox 1']"));
        WebElement cBoxElement2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!(cBoxElement1.isSelected())) {
            cBoxElement1.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!(cBoxElement2.isSelected())){
            cBoxElement2.click();
        }
        //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(cBoxElement1.isSelected());
        Assert.assertTrue(cBoxElement2.isSelected());
    }
    @After
    public void teardown(){
        //driver.close();
    }
}
