package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C03_SwitchingMethods extends TestBaseQuit  {
    @Test
    public void test01(){
        // amazon ana sayfaya gidin
        // url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String amazonWHD = driver.getWindowHandle();
        // Yeni bir tab olarak wise quarter anasayfaya gidin
        // title'in Wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        Assert.assertTrue(driver.getTitle().contains("Wise"));
        String wiseWHD = driver.getWindowHandle();
        // yeni bir window acarak youtube sayfasina gidin
        // url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
        // acilan tum sayfalari kapatin

    }
}
