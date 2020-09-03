package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // En onemli kodu; switchTo().alert()
    @Test
    public void jsAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();

        /*Alert alert = driver.switchTo().alert();   seklinde nesne olusturup da kullanabiliriz
        alert.dismiss();
        alert.accept();
        alert.getText();
        alert.sendKeys("Gerek yok");
        */

        // Alert in icerdigi mesaji almak icin getText() kullanilir
        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);
        // Alert in icerisindeki OK buttonuna tiklamak icin kullanilir
        driver.switchTo().alert().accept();
        // Alert e yazi gondermek sendKeys() icin kullanilir
        //driver.switchTo().alert().sendKeys();
        // Alert in icindeki Cancel tusuna basmak icin kullanilir
        //driver.switchTo().alert().dismiss();
    }

    @Test
    public void jsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button2.click();

        String alertMesaji2 = driver.switchTo().alert().getText();
        System.out.println(alertMesaji2);

        driver.switchTo().alert().dismiss();

    }

    @Test
    public void jsPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button3.click();

        String alertMesaji3 = driver.switchTo().alert().getText();
        System.out.println(alertMesaji3);

        driver.switchTo().alert().sendKeys("Merhaba TestNG...");

        driver.switchTo().alert().accept();
    }
}
