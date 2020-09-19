package com.techproed.tests;

import com.techproed.pages.GoogleAramaPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// Rapor alacagimizdan TestBaseFinal i miras aliyoruz
public class GoogleAramaTest extends TestBaseFinal {

    @Test
    public void aramaTesti() throws InterruptedException {
        extentTest = extentReports.createTest("GoogleArama","Google da techproeducation.com aramasi yaptik");

        extentTest.info("Sayfa adresine git");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

        extentTest.info("webelement kullanabilmek icin nesne olustur");
        GoogleAramaPage googleAramaPage = new GoogleAramaPage();

        extentTest.info("techproeducation.com aramasi yap");
        googleAramaPage.aramaKutusu.sendKeys("techproeducation" + Keys.ENTER);

        extentTest.info("3 saniye bekle");
        Thread.sleep(3000);

        extentTest.info("tum linkleri for-loop ile karsilastir");
        boolean linkVarMi = false;

        for(WebElement w: googleAramaPage.tumLinkler){
            if(w.getText().contains("techproeducation.com")){
                linkVarMi=true;
                break;
            }
        }
        extentTest.info("Assert islemi yap");
        Assert.assertTrue(linkVarMi);
        extentTest.pass("Testimiz PASSED !");
    }
}
