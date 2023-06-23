package tests.teamPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P03_DropDownMenu extends TestBase {
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //DropDown menuyu locate edin ve Select Class'dan olusturulacak bir objeyle kullaniniz
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDownElement);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByIndex(1);
        System.out.println("OPTION: "+select.getFirstSelectedOption().getText());

        System.out.println("================================");
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println("OPTION: "+select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        System.out.println("================================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        //4.Tüm dropdown değerleri(get text) yazdırın
        System.out.println("================================");
        List<WebElement> dDMList = select.getOptions();

        for (WebElement eachElement: dDMList
             ) {
            System.out.println(eachElement.getText());
        }

        //5. Dropdown’un boyutunun 3 olduğunu test edin
        Assert.assertEquals(3,dDMList.size());

    }
}
