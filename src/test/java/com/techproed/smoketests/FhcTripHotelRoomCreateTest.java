package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripHotelRoomCreateTest extends TestBase {
    /*
    ----------------------------HOTEL ODASI OLUŞTURMA-------------------------
***** Bulmamız gereken webelementler.
IDHotel, Code, Name, Location, Description, Price, 500, Room type,
Max Adult count, Max Children count, Approved, Save
1. Adım : Tüm webelementleri "pages" paketinin altında oluşturacağımız,
FhcTripHotelRoomCreatePage class'ının içerisinde @FindBy şeklinde bulalım.
2. Adım : smoketests -> FhcTripHotelRoomCreateTest class oluşturalım.
3. Adım : FhcTripHotelRoomCreateTest class'ının içerisinde @Test methodu oluşturacağız.
4. Adım : driver.get(ConfigurationReader.getProperty("room_create_url")) ile HotelRoomCreate sayfasına gidelim.
5. Adım : FhcTripHotelRoomCreatePage class'ından nesne oluşturalım ve içerisindeki webelementleri kullanalım.
6. Adım : WebElementlerin içerisini dolduralım.
     */


    @Test
    public void testHotel(){
        driver.get(ConfigurationReader.getProperty("room_create_url"));

        FhcTripHotelRoomCreatePage page = new FhcTripHotelRoomCreatePage(driver);
        page.aramaKutusu.sendKeys(ConfigurationReader.getProperty("username"));
        page.password.sendKeys(ConfigurationReader.getProperty("password"));
        page.login.click();

        // Secerek kaydetmek icin Select
        Select select1 = new Select(page.idHotelDropDown);
        select1.selectByIndex(3);

        page.codeBox.sendKeys("1234");
        page.nameBox.sendKeys("Aydin Takte");
        page.locationBox.sendKeys("Nederland");
        page.descKutusu.sendKeys("Day20 den selam");

        // Tasiyarak kaydetmek icin Actions
        Actions action = new Actions(driver);
        action.dragAndDrop(page.priceBesYuz, page.priceBox).perform();

        Select select2 =new Select(page.idGroupRoomTypeDropDown);
        select2.selectByIndex(2);

        page.maxAdultCountBox.sendKeys("2");
        page.maxChildCountBox.sendKeys("5");

        page.saveButonu.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean basarili = page.basariliYazisi.isDisplayed();
        Assert.assertTrue(basarili);

    }
}
