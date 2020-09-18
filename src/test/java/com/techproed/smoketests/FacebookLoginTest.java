package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {

    @Test
    public void girisTest(){
        driver.get(ConfigurationReader.getProperty("face_web"));
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);

        loginPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("username_face"));
        loginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("password_face"));
        loginPage.giris.click();
    }
}
