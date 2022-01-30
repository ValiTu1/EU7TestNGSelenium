package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExcelDDFTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



    @DataProvider
    public Object[][] getDataExcel(){

        ExcelUtil readFile = new ExcelUtil("src/test/resources/StatusCodes.xlsx", "Sheet1");

        readFile.getDataArrayWithoutFirstRow();


        String[][] data = readFile.getDataArrayWithoutFirstRow();



        return data;
    }


    @Test(dataProvider = "getDataExcel")
    public void statusCodesTests(String code, String expectedMessage){


        driver.findElement(By.linkText(code)).click(); //clicks on 200 status code

        String actualMessage = driver.findElement(By.tagName("p")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }


}
