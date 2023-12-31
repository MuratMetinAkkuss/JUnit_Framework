package tests.day07_testbase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        // Username    : admin
        //  password     : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement nededData = driver.findElement(By.tagName("p"));
        Assert.assertTrue(nededData.isDisplayed());

    }
}
