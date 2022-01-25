package com.cybertek.tests.day12_properties_driver_tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task3_01022022 {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //login to the webiste
        WebElement userName = driver.findElement(By.xpath("//div[@class='login']/input[1]"));
        userName.sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        //click on Orders tab
        driver.findElement(By.linkText("Order")).click();

        //locating the dropdown options

        WebElement dropdownElement = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select = new Select(dropdownElement);

        //checking for default value from dropdown
        String expectedValue = "MyMoney";
        String actualValue = select.getFirstSelectedOption().getText();
        System.out.println("Actual value: " + actualValue);



        Assert.assertEquals(expectedValue, actualValue);

        //selecting FamilyAlbum from dropdown list
        select.selectByIndex(1);

        //makeing quatity 2

        WebElement quatitybox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quatitybox.clear();
        quatitybox.sendKeys("2");

        //clicking on Calculate button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        Thread.sleep(1000);

        //checking for the right total
        WebElement actualTotal =  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));

        String quantity = (quatitybox.getAttribute("value"));

        WebElement pricePerUnitbox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        String valueOfPricePerUnit = pricePerUnitbox.getAttribute("value");

        int expectedTotal = Integer.parseInt(quantity)  * Integer.parseInt(valueOfPricePerUnit);

        Assert.assertEquals(expectedTotal, actualTotal);


    }
}
