package com.juaracoding.moduletests;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.modules.AddToCartModule;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartModuleTests {
    public static WebDriver driver;
    public AddToCartModule atcm;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
        atcm = new AddToCartModule();
    }

    @Test
    public void addToCartTest(){
        atcm.mainPage();
        atcm.chooseVariant();
        Assert.assertEquals(atcm.validatePage(),"CART");
    }

    @AfterSuite
    public void quitBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
