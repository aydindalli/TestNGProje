package com.techproed.tests;

import com.techproed.pages.FhcTripPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhctripQaTest extends TestBase {

    @Test (groups = {"fhctrip","login"})
    public void aramaFhcTrip(){
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");

        // FhcTripPage den nesne uretip oradan WebElementleri buluyoruz
        FhcTripPage fhcTripPage = new FhcTripPage(driver);
        fhcTripPage.aramaKutusu.sendKeys("manager2 ");
        fhcTripPage.password.sendKeys("Man1ager2!");
        fhcTripPage.login.click();
    }
}
