package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage {


    WebDriver driver;

    public HotelPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy (id = "Address")
    public WebElement adres;

    @FindBy (id = "Phone")
    public WebElement telefon;

    @FindBy (id = "Email")
    public WebElement email;

    @FindBy (id = "IDGroup")
    public WebElement idGroup;

    @FindBy (id = "btnSubmit")
    public WebElement buttonSave;
}
