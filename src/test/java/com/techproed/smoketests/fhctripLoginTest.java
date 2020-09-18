package com.techproed.smoketests;

import com.techproed.pages.FhcTripPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class fhctripLoginTest extends TestBase {


    @Test
    public void girisTesti(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));

        FhcTripPage loginPage = new FhcTripPage(driver);
        loginPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.login.click();
    }
}

