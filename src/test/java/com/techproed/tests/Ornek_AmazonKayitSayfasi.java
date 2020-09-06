package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ornek_AmazonKayitSayfasi extends TestBase {

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();

        WebElement startButton = driver.findElement(By.partialLinkText("Start here"));
        startButton.click();

        //Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(),"Amazon Registration");
    }

    @Test (dependsOnMethods = "test01")
    public void test02(){
        //driver.get("http://amazon.com");
        WebElement name= driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("AydinDalli");
        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("aydindalli22@gmail.com");
        WebElement passwordBen= driver.findElement(By.id("ap_password"));
        passwordBen.sendKeys("Abe12345%");
        WebElement passTekrar = driver.findElement(By.id("ap_password_check"));
        passTekrar.sendKeys("Abe12345%");
        driver.findElement(By.id("continue")).click();
    }


}
