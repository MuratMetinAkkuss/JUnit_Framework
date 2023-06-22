package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C04_SwitchingWindow extends TestBaseQuit {
    @Test
    public void test01(){
        //amazon'a gidin
        driver.get("https://www.amazon.com");
        String wHDAmazon = driver.getWindowHandle();
        //wisequarter'a gidin
        driver.get("https://www.wisequarter.com");
        String wHDWise = driver.getWindowHandle();
        //youtube'a gidin
        driver.get("https://www.youtube.com");
        String wHDYoutube = driver.getWindowHandle();

        //amazona gidin ve URL'in amazon icerdigini kontrol edin
        driver.switchTo().window(wHDAmazon);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //wise quarter'in acik oldugu sayfaya gidin ve title'in wise icerdigini test edin
        driver.switchTo().window(wHDWise);
        Assert.assertTrue(driver.getTitle().contains("Wise"));

        //youtube'un acik oldugu sayfaya gidin ve url'in youtube icerdigini test edin
        driver.switchTo().window(wHDYoutube);
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));

    }
}
