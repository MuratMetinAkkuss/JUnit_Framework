package tests.teamPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01_CheckBox extends TestBase {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1Element.isSelected()){
            checkBox1Element.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2Element.isSelected()){
            checkBox2Element.click();
        }
        //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkBox1Element.isSelected());
        Assert.assertTrue(checkBox2Element.isSelected());
    }
}
