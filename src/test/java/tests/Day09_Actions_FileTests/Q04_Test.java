package tests.Day09_Actions_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.AmazonTestBaseAfterClass;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class Q04_Test extends AmazonTestBaseAfterClass {
    @Test
    public void test01(){
        //1- amazon gidin
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu =driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropDownMenu);
        List<WebElement> dDMSet = select.getOptions();
        for (WebElement eachSelect: dDMSet
             ) {
            System.out.println(eachSelect.getText());
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertEquals(40,dDMSet.size());
    }
    @Test
    public void test02(){
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropDownMenu =driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropDownMenu);
        select.selectByValue("search-alias=electronics-intl-ship");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("iphone"+ Keys.ENTER);
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String iPhone =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(iPhone.contains("iphone"));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement firstProduct = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(firstProduct));
        secondProduct.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String productName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(productName);
        String productPrice = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        System.out.println(productPrice);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }
    @Test
    public void test03(){
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");
        //2-dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu =driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Baby");
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("bebek puset"+ Keys.ENTER);
        //4-sonuç yazsının puset içerdiğini test edin
        String iPhone =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(iPhone.contains("puset"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement firstProduct = driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).above(firstProduct));
        secondProduct.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String productName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(productName);
        String productPrice = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        System.out.println(productPrice);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }

}
