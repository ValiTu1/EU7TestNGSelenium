package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void wrongPasswordTest(){

        loginPage= new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtnInput.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){
        loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtnInput.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

}

