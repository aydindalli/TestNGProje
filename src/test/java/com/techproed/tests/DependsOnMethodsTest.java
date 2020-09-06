package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DependsOnMethodsTest extends TestBase {

    @Test (dependsOnMethods = "googleTest") //  amazon dan once google
    public void amazonTest(){
        driver.get("http://amazon.com");
    }

    @Test (dependsOnMethods = "facebookTest")   // google den once facebook
    public void googleTest(){
        driver.get("http://google.com");
    }

    @Test
    public void facebookTest(){
        driver.get("http://facebook.com");
    }
    // Dolayisi ile sira; facebookTest = googleTest = amazonTest

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
