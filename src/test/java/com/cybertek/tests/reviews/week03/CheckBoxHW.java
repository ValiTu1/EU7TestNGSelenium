package com.cybertek.tests.reviews.week03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxHW {

    WebDriver driver;

    @BeforeClass

    public void setClass(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @BeforeMethod
    public void openPage(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

    }

    @Test

    public void checkBoxAll(){

    }




}
