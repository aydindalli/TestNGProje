package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage<list> {

    // bos bir tane driver degiskeni olusturduk from instance variable
    WebDriver driver;
    public GooglePage(WebDriver driver){

        // Parametre olarak gelen driver nesnesini bu class da olusturdugumuz driver nesnesine esitledik
        // Bu sekilde yeniden bos bir driver olusturmak yerine zaten halihazirda kullandigimiz driver i bu nesneye esitlemis olduk
        this.driver = driver;

        // Birazdan bulacagimiz webelementleri hazir hale getirdik
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "q")
    public WebElement aramaKutusu;   // findEelement

    @FindBy (id = "id_degeri")
    public WebElement key;           //findElement

    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> liste;    // findElemenets




}
