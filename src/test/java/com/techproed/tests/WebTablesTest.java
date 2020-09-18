package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    /*
    <table WebElement'ini incelemiştik.
    <thead  : Tablonun üst kısmı (başlıklar vs.)
    <tbody  : Tablonun satırlarının yer aldığı kısımdı.
    <tr     : TableRow - satırların tagName'i
    <td     : TableData- satırların içerisindeki hücrelerin tagName'i

    *** Eğer tablodaki tüm satırları almak istiyorsak ?
            List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));

    *** Eğer tablodaki 3. satırı almak istersek ?
            WebElement ucuncuSatir = driver.findElement(By.xpath("//tbody/tr[3]"));

    *** Eğer tablodaki 5. satır, 3. sütunu almak istiyorsak ?
            WebElement ucBes = driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));

    *** "/" ve "//" arasındaki fark nedir?
    - Tek slash("/") childi verir.
    - Çift slash("//") childi, torunu, ya da daha alt nesli verebilir.

     */

    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }

    @Test
    public void table(){
        giris();

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> list = driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println(" ");
        for(WebElement w: list){
            System.out.println(w.getText());
        }

    }

    @Test
    public void tumSatirlar() {
        giris();

        List<WebElement> satirSatir = driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement w : satirSatir) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void tumHucreler(){
        giris();

        List<WebElement> tekTekHucreleri = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement q : tekTekHucreleri){
            System.out.println(q.getText());
        }
    }

    @Test
    public void tumSutun(){
        giris();

        List<WebElement> sutunSutun = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for(WebElement x: sutunSutun){
            System.out.println(x.getText());
        }
    }



    @Test
    public void hucreYazdir(int satir,  int sutun){
        giris();
        String xpathDegerim = "//tbody/tr["+  satir  +"]/td["+  sutun  +"]";
        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());
    }

    @Test
    public void calistir(){
        giris();
        hucreYazdir(3,4);
        hucreYazdir(7,3);
        hucreYazdir(9,1);
    }
}
