package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GlpSignUpTest {
    /*
    @BeforeSuite
        @BeforeTest
            @BeforeClass
                @BeforeGroup
                    @BeforeMethod
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite çalıştı");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest çalıştı");
    }
    @Test (groups = "glbtrader")
    public void Test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_web"));

        GlbSignUpPage page = new GlbSignUpPage();

        page.emailBox.sendKeys(ConfigurationReader.getProperty("glb_email"));
        page.nameBox.sendKeys(ConfigurationReader.getProperty("glb_name"));
        page.telBox.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        page.passwordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        page.rePasswordBox.sendKeys(ConfigurationReader.getProperty("glb_sifre"));

        page.singUpButton.click();

        System.out.println(page.basariliYazisi.getText());

        Assert.assertTrue(page.basariliYazisi.getText().contains("Success"));
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
