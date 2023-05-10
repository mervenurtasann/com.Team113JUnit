package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClass;

public class C02_JSAlerts extends TestBaseBeforeClass {
    /*
        Otomasyon yaparken iki tur alert ile karsilasabiliriz
        1- HTML alerts :
           HTML kodlari ile olusturulmus alert'lerdir
           HTML ile olusturuldugu icin inspect edilebilir,
           locate edilebilir ve driver ile kullanilabilir

        2- JacaScript Alerts :
           Inspect yapilamaz, locate edilemez
           Testlerimiz sirasinda JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanarak
           alert'e gecis yapabilir ve alert uzerinde
           OK, Cancel, Alert yazisini alma getText()
           ve alert'e yazi yollama senKeys()
           method'larini kullanabiliriz
     */

    // 3 test method’u olusturup asagidaki gorevi tamamlayin
    //1. Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 1.alert’e tiklayin
    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    // - OK tusuna basip alert’i kapatin
    //2.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 2.alert’e tiklayalim
    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    //3.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // - 3.alert’e tiklayalim
    // - Cikan prompt ekranina “Abdullah” yazdiralim
    // - OK tusuna basarak alert’i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01() {
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);

    }

    @Test
    public void test03() {
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();

        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
