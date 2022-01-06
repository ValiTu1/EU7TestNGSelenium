package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger")).click();

        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("username")).sendKeys("Mike Smith");
        Thread.sleep(2000);

    }
}
