package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    @Test
    public void aramaAmazon(){
        driver.get("http://amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);      // AmazonPage den bir nesne uretelim
        amazonPage.aramaKutusu.sendKeys("Amac");// Artik o webelement i kullanabiliyoruz
    }
}
