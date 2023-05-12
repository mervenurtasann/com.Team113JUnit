package day10_actionsClass_Faker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KlavyeActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions = new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));

        actions.click(isimKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Karahan")
                .sendKeys(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Malatya44")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //4- Kaydol tusuna basalim

        Thread.sleep(5000);
    }
}
