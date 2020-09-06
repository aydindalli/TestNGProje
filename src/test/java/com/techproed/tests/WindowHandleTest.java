package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowHandleTest extends TestBase {
    /*
    driver.getWindowHandles()
    1. Handle  :  "CDwindow903439NKDSFD8SFUS9D8F"
    2. Handle  :  "CDwindows9F8DS0FF9S8JG9FSVV6S"
    driver.switchTo().window("CDwindows9F8DS0FF9S8JG9FSVV6S");
     */


    @Test
    public void cokluPencereTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.partialLinkText("Click Here")).click();
        Set<String> tumPencereler =  driver.getWindowHandles();
        for(String w: tumPencereler){
            System.out.println(w);
        }

        Object[] array = tumPencereler.toArray();
        String ikinciSayfaHandle = array[array.length - 1].toString();
        System.out.println(ikinciSayfaHandle);

        driver.switchTo().window(sayfaninHandle);// ilk sayfaya handle ile geri doner

        }

}
