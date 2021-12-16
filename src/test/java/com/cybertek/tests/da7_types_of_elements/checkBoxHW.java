package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class checkBoxHW {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
    }
    /*@Test
    public void logIn() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();

        Thread.sleep(3000);
        driver.quit();
    }*/

    @Test
    public void checkAll() throws InterruptedException {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        WebElement idAttribute;
        for (int i = 2; i < 10; i++) {
            String num = "" + i;

            idAttribute = driver.findElement(By.id(("ctl00_MainContent_orderGrid_ctl0" + num + "_OrderSelector")));
            Assert.assertTrue(idAttribute.isSelected());
        }

    }
    @Test
    public void uncheckAll() throws InterruptedException {
        checkAll();

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        String idAttribute = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        for (int i = 2; i < 10; i++) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertTrue(driver.findElement(By.id(idAttribute)).isSelected());
        }
        WebElement uncheckButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckButton.click();
        for (int i = 2; i < 10; i++) {
            String num = "" + i;
            idAttribute = idAttribute.replace(idAttribute.charAt(32), num.charAt(0));
            Assert.assertFalse(driver.findElement(By.id(idAttribute)).isSelected());
        }
    }

    @Test
    public void deleteAPerson() throws InterruptedException {


        WebElement deletedPerson = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        deletedPerson.click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        Assert.assertNotEquals(deletedPerson, driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector")));

    }

    @AfterMethod
    public void endingTest() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();

    }
}