package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {
    /*
    çift tıklama : actions.doubleClick(webelement).perform();
    sağ tıklama  : actions.contextClick(webelement).perform();
    hover over   : actions.moveToElement(webelemnt).perform();
    scroll down  : actions.sendKeys(Keys.PAGE_DOWN).perform();
		    	   actions.sendKeys(Keys.END).perform();
	    		   actions.sendKeys(Keys.ARROW_DOWN).perform();
    scroll up    : actions.sendKeys(Keys.PAGE_UP).perform();
			       actions.sendKeys(Keys.ARROW_UP).perform();
     */

    @Test
    public void sagTiklama(){

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        // Bir webelemente sag tiklamak icin
        actions.contextClick(element).perform();


    }
    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
        actions.doubleClick(button).perform();
    }
    @Test
    public void hoverOver(){
         driver.get("http://amazon.com");
         WebElement menu = driver.findElement(By.id("nav-link-accountList"));
         Actions actions2 = new Actions(driver);
         actions2.moveToElement(menu).perform();
        }

    @Test
    public void asagiYukari(){
        driver.get("http://amazon.com");
        // scrol up ve down yapar
        Actions actions3 = new Actions(driver);
        actions3.sendKeys(Keys.PAGE_DOWN).perform();
        actions3.sendKeys(Keys.END).perform();
        actions3.sendKeys(Keys.PAGE_UP);
        actions3.sendKeys(Keys.ARROW_DOWN);

    }
}
