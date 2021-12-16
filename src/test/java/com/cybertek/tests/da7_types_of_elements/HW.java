package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

        WebElement checkAllButton = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));

        checkAllButton.click();

        String checkBox1ID = "ctl00_MainContent_orderGrid_ctl02_OrderSelector";
        String checkBox2ID = "ctl00_MainContent_orderGrid_ctl03_OrderSelector";
        String checkBox3ID = "ctl00_MainContent_orderGrid_ctl04_OrderSelector";
        String checkBox4ID = "ctl00_MainContent_orderGrid_ctl05_OrderSelector";
        String checkBox5ID = "ctl00_MainContent_orderGrid_ctl06_OrderSelector";
        String checkBox6ID = "ctl00_MainContent_orderGrid_ctl07_OrderSelector";
        String checkBox7ID = "ctl00_MainContent_orderGrid_ctl08_OrderSelector";
        String checkBox8ID = "ctl00_MainContent_orderGrid_ctl09_OrderSelector";
        //checkbox1
        WebElement checkBox1 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));

        Assert.assertTrue(checkBox1.isSelected(), "checkbox1 should be selected");

        //checkbox2
        WebElement checkBox2 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));

        Assert.assertTrue(checkBox2.isSelected(), "checkbox2 should be selected");


        //checkbox3
        WebElement checkBox3 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl04_OrderSelector"));

        Assert.assertTrue(checkBox3.isSelected(), "checkbox3 should be selected");

        //checkbox4
        WebElement checkBox4 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector"));

        Assert.assertTrue(checkBox4.isSelected(), "checkbox4 should be selected");

        //checkbox5
        WebElement checkBox5 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector"));

        Assert.assertTrue(checkBox5.isSelected(), "checkbox5 should be selected");

        //checkbox6
        WebElement checkBox6 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));

        Assert.assertTrue(checkBox6.isSelected(), "checkbox6 should be selected");

        //checkbox7
        WebElement checkBox7 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector"));

        Assert.assertTrue(checkBox7.isSelected(), "checkbox7 should be selected");

        //checkbox8
        WebElement checkBox8 = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector"));

        Assert.assertTrue(checkBox8.isSelected(), "checkbox8 should be selected");

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        //driver.navigate().refresh();

        Thread.sleep(1000);

        //checkbox1
        Assert.assertFalse(driver.findElement(By.id(checkBox1ID)).isSelected(), "checkbox1 should NOT be selected");

        //checkbox2
        Assert.assertFalse(driver.findElement(By.id(checkBox2ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox3
        Assert.assertFalse(driver.findElement(By.id(checkBox3ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox4
        Assert.assertFalse(driver.findElement(By.id(checkBox4ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox5
        Assert.assertFalse(driver.findElement(By.id(checkBox5ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox6
        Assert.assertFalse(driver.findElement(By.id(checkBox6ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox7
        Assert.assertFalse(driver.findElement(By.id(checkBox7ID)).isSelected(), "checkbox2 should NOT be selected");

        //checkbox8
        Assert.assertFalse(driver.findElement(By.id(checkBox8ID)).isSelected(), "checkbox2 should NOT be selected");



        String checkBoxXPath = "//input[@id='" + checkBox1ID + "']/../../" ;

        driver.findElement(By.xpath(checkBoxXPath + "td[1]")).click();
        WebElement getName = driver.findElement(By.xpath(checkBoxXPath + "td[2]"));

        String expectedName = getName.getText();


        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        WebElement getNewName = driver.findElement(By.xpath("//td[2]"));

        String newList = getNewName.getText();
        System.out.println(newList);

        Assert.assertFalse(newList.contains(expectedName));


        //Assert.assertFalse(driver.findElement(By.id(checkBox1ID)).isDisplayed(),"checkbox should not exist anymore");

        driver.quit();
    }
}
