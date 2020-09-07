package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir")); // Suan bulundugumuz dosyayi adini verir
        System.out.println(System.getProperty("user.home")); //Suan bulundugunuz dosyanin klasor adini verir
        String kullaniciDosyaYolu = System.getProperty("user.dir");
        // C:\Users\HP\IdeaProjects\TestNGProje
        String pomXmlDosyaYolu = kullaniciDosyaYolu+"/pom.xml";
        System.out.println(pomXmlDosyaYolu);
        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyaUpload(){ // bilgisayardan websayfasına doysa yükleme
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));

        // yüklemek istediğimiz dosyanın, path(dosya yolunu) ekleyelim.
        dosyaSecmeButonu.sendKeys("C:/Users/HP/Desktop/Logo/logo.png");
        //dosyaSecmeButonu.sendKeys("C:\\Users\\isimsiz\\upload\\logo.png");

        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();

        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }

    @Test
    public void dosyaDownload() {

        driver.get("http://the-internet.herokuapp.com/download");
        WebElement amsterDam = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterDam.click();


        boolean varYok = Files.exists(Paths.get("C:\\Users\\HP\\Downloads\\Amsterdam.jpg"));
        System.out.println(varYok);
        Assert.assertTrue(varYok);

    }
}
