package com.techproed.tests;

import com.techproed.pages.HotelPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelTest extends TestBase {

    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ 	Keys.ENTER);
    }

    @Test (groups = {"fhctrip","hotelolustruma"})
    public void aramaHotel(){
        giris();

        HotelPage hotelPage = new HotelPage(driver);

        hotelPage.code.sendKeys("1234");
        hotelPage.name.sendKeys("TechproEd");
        hotelPage.adres.sendKeys("Cikmaz Sok.");
        hotelPage.telefon.sendKeys("0212 540 1234");
        hotelPage.email.sendKeys("dallilar@gmail.com");

        Select select = new Select(hotelPage.idGroup); // dropdown
        select.selectByIndex(2);
        hotelPage.buttonSave.click();
    }
}
