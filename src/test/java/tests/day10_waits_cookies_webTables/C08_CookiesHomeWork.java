package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C08_CookiesHomeWork extends TestBase {
    @Test
    public void test01(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue = "USD";
        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedValue,actualValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.contains(cookie));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();
        boolean flag = false;
        for (Cookie each:cookieSet
             ) {
            if (each.getName().equals("skin")){
                flag=true;
            }
        }
        Assert.assertFalse(flag);
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertEquals(0,cookieSet.size());
    }
}
