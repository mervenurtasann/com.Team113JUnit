package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. foto.png dosyasını indirelim
        WebElement fotoElementi = driver.findElement(By.linkText("foto.png"));
        fotoElementi.click();
        Thread.sleep(3000);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Dosyayi Downloads klasorune indiricek

        String dosyaYolu = "C:\\Users\\engintasan\\Downloads/foto.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
    }
}
