package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void loginAsDriver(){


        loginPage= new LoginPage();

        /*String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);
*/
        loginPage.loginAsDriver();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");


    }

    @Test
    public void loginAsStoreManager(){

        loginPage= new LoginPage();

        loginPage.loginAsStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

}
