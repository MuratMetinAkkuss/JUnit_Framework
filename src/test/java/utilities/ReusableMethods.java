package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethods {
    
    public static String WindowHandleForPages(String firstWHDPAge , WebDriver driver){
        String wHDSecondPage = " ";
        Set<String> wHDPagesSet = driver.getWindowHandles();
        for (String each: wHDPagesSet
             ) {
            if (!firstWHDPAge.equals(each)){
                wHDSecondPage = each;
            }
        }
        return wHDSecondPage;
    }
    
    
}
