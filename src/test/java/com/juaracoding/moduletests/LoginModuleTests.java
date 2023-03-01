package com.juaracoding.moduletests;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.modules.LoginModule;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginModuleTests {
    public static WebDriver driver;
    public LoginModule lm;

    @BeforeSuite
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        lm = new LoginModule();
        driver.get("https://shop.demoqa.com/");
    }

    @Test
    public void loginTest() {
        lm.dismissCookie();
        delay(2);
        lm.loginCredentials("zuikaku-chan","Zuikaku_ZuiZui5");
        Assert.assertEquals(lm.validatePageAfterLogin(),"zuikaku-chan");
    }

    static void delay(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
