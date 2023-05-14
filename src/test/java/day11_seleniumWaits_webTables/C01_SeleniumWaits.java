package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
        Otomasyon yaparken
        sayfanin yuklenmesi ve webelementlerin bulunmasi icin gerekli sureyi
        implicitly wait ile ayarlariz

        Implicitly wait sayfanin yuklenmesi ve
        her bir webelementin bulunmasi icin tanimlanan
        max bekleme suresidir.
        her islem icin sifirdan baslar ve max sure doluncaya kadar
        gorevi tamamlamaya calisir
        max sure icerisinde gorec tamamlanmazsa
        exception verip calismayi durdurur

        Testlerin buyuk cogunlugunda
        implicitly wait suresi
        sekronizasyonu saglamak icin yeterli olur
        ANCAK
        ozel bir gorev icin implicitly wait'de tanimlanan
        max bekleme suresinde daha fazla beklememiz gerekirse
        O GOREVE OZGU, TEK SEFERLIK bir wait olusturabiliriz

     */

    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void test01() {

        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test method'unda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();
    }

    @Test
    public void explicitlyWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
            Burada testi manuel olarak yapip
            bir karar vermemiz gerekiyor
            1- test etmek istedigimiz webelement zaten gorunuyorsa
               webelement'i locate yapip sonra ozel beklemeyi tanimlarim
            2- test etmek istedigimiz webelementin ulasilabilir olmasi icin
               beklemek gerekiyorsa
               locator'i verip, "bu locator ile bir element locaate edene kadar
               exception firlatma bekle" diyebiliriz
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[1]")));

        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
}
