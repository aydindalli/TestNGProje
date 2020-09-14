package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelRoomCreatePage {
    WebDriver driver;
    public FhcTripHotelRoomCreatePage(WebDriver driver){
        this.driver = driver;
        // parametre olarak iki degisken "driver, this"
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "UserName")
    public WebElement aramaKutusu;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement login;

    @FindBy (id = "IDHotel")
    public WebElement idHotelDropDown;

    @FindBy (id = "Code")
    public WebElement codeBox;

    @FindBy (id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Location")
    public WebElement locationBox;

    @FindBy ( xpath = "//textarea[@dir='ltr']")
    public WebElement descKutusu;

    @FindBy(id = "Price")
    public WebElement priceBox;

    @FindBy(partialLinkText = "500")
    public WebElement priceBesYuz;

    @FindBy(id = "IDGroupRoomType")
    public WebElement idGroupRoomTypeDropDown;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCountBox;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCountBox;

    @FindBy (id = "IsAvailable")
    public WebElement approved;

    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy ( xpath = "//*[.='HotelRoom was inserted successfully']")
    public WebElement basariliYazisi;
}
