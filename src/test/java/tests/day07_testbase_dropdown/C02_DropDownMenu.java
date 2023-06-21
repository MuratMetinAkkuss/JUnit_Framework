package tests.day07_testbase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownMenu extends TestBase {

    @Test
    public void test01(){
        //amazona gidin
        driver.get("https://www.amazon.com");
        //arama kutusunun yanindaki dropdown menude 34 secenek oldgunu test
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);

        int expectedOptions = 28;
        int actualoptions = select.getOptions().size();

        Assert.assertEquals(expectedOptions,actualoptions);

        //dropdown menude baby kategorisini secin

        select.selectByVisibleText("Baby");

        //arama kutusunda nutella yazip aratin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        //bulunan sonuc sayisinin 10'dan fazla oldugunu test edin
        WebElement result = driver.findElement(By.xpath("//span[text()='11 results for']"));

        String actualResult = result.getText().substring(0,result.getText().indexOf(" "));
        int actualResultInt = Integer.parseInt(actualResult);
        Assert.assertTrue(actualResultInt>10);
        //sectiginiz opsiyonu yazdirin
        /*
            biz daha once dropdown menu locate etmis
            ve bu menuyu kullanarak selecet objesi olusturmustuk

            Ancak
            arama yaptirdigimizda HTML kodlar yenilendigi icin
            eski elementleri BULAMAYABILIR
            bu durumda "stale element" uyarisi verir

            yapmamiz gereken
            yeniden obje olusturmak degildir,
            olan objelere assginment yapmaktir

         */
        ddm = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(ddm);

        System.out.println(select.getFirstSelectedOption().getText());

        //sectiginiz opsiyonun baby oldugunu test edin

        Assert.assertEquals("Baby",select.getFirstSelectedOption().getText());


    }

}
