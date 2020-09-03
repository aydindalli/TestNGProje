package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PriorityTest {


    //TestNG Annotations :    @BeforeSuite @AfterSuite
    //                        @BeforeTest  @AfterTest
    //                        @BeforeClass @AfterClass
    //                        @BeforeGroups @AfterGroups
    //                        @BeforeMethod @AfterMethod
    //                        @Test        @Ignore

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    // priority ile testleri oncelik sirasina gore siralayabiliriz
    @Test (priority = 1)
    public void dropDownTest(){
        driver.get("http://amazon.com");
        String titleAmazon = driver.getTitle();
        System.out.println(titleAmazon);

    }

    @Test (priority = 0)
    public void googleAramaTest(){
        driver.get("http://google.com");
        String titleGoogle = driver.getTitle();
        System.out.println(titleGoogle);
    }

    @Test (priority = 2)
    public void baslikTesti(){
        driver.get("http://facebook.com");
        String titleFacebook = driver.getTitle();
        System.out.println(titleFacebook);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
