package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2_01022022 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 20);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        driver.findElement(By.id("enable-button")).click();
        WebElement disableButton = driver.findElement(By.id("disable"));
        wait.until(ExpectedConditions.elementToBeClickable(disableButton));
        disableButton.click();
        Assert.assertTrue(disableButton.isEnabled());
    }
}
