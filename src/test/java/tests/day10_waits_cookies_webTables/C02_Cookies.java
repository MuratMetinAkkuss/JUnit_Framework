package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet =driver.manage().getCookies();
        int counter = 1;
        for (Cookie each:cookieSet
             ) {
            System.out.println( counter + ". cookie = " + each);
            counter++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookie = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookie);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie1 = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie1);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet =driver.manage().getCookies();
        Assert.assertTrue(cookieSet.contains(cookie1));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        /*
            Yok oldugunu test etmek icin tum cookie isimlerini kontrol edelim
            bir flag kullanip ismi skin olan varsa flag'i degistirelim.
         */
        cookieSet =driver.manage().getCookies();
        boolean flag = false;
        for (Cookie each:cookieSet
             ) {
            if (each.getName().equals("skin")){
                flag = true;
                break;
            }
        }
        Assert.assertFalse(flag);
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet =driver.manage().getCookies();
        Assert.assertEquals(0,cookieSet.size());
    }
}
