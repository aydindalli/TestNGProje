package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*
    SoftAssert kullaniminin Hard Assert kullanimindan farklari:
    1. basarisiz testten sonra kalan kisim calisir
    2. SoftAssert classindan nesne olusturmak zorundayiz

    ****** Assert => HardAssert (Assert.assertTrue())
           Verify => SoftAssert (SoftAssert)


           Assertion - Test Case
     */

    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){

        SoftAssert softAssert = new SoftAssert();
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);

        softAssert.assertAll(); // HArdassert ile ayni

    }

    @Test
    public void test02(){
        driver.get("http:a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();

        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
        softAssert.assertTrue(emailKutusu.getText().equals("testtechproed@gmail.com"));

        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");
        softAssert.assertTrue(driver.getTitle().equals("Address book"));

        WebElement signInButton= driver.findElement(By.name("commit"));
        signInButton.click();

        WebElement signOutLinki = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu = signOutLinki.isDisplayed();

        // Assert.assertTrue(gorunuyorMu);   bu hard assert ile yapilan
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
