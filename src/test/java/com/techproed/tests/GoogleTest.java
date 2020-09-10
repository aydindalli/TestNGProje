package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void aramaTesti(){
        driver.get("http://google.com");

        // Google page class indan direkt bir tane nesne olusturduk ve parametre olarak suan kullandigimiz driver i gonderdik

        GooglePage googlePage = new GooglePage(driver);

        googlePage.aramaKutusu.sendKeys("Mountain fiest");
    }

}
