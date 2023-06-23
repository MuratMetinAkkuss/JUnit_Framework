package tests.teamPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P04 extends TestBase {
    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement userNameElement = driver.findElement(By.id("user_login"));
        userNameElement.sendKeys("username");
        //4. Password kutusuna “password.” yazin
        WebElement userPasswordElement = driver.findElement(By.id("user_password"));
        userPasswordElement.sendKeys("password");
        //5. Sign in tusuna basin
        WebElement signInElement = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInElement.click();
        //Guvenlik sayfasini back yap
        driver.navigate().back();
        //6. online banking sekmesindeki Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dDMElement = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dDMElement);
        select.selectByValue("EUR");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("25");
        //10. “US Dollars” in secilmedigini test edin
        Assert.assertNotEquals("US Dollars", select.getFirstSelectedOption().getText());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        Assert.assertEquals("Foreign currency cash was successfully purchased.",
                driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']")).getText());
    }
}
