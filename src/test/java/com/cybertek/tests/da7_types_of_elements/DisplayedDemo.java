package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInputBox = driver.findElement(By.id("username"));

        System.out.println("userNameInputBox.isDisplayed() " +  userNameInputBox.isDisplayed());

        Assert.assertFalse(userNameInputBox.isDisplayed(), "the input box should NOT be displayed");


        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        Thread.sleep(5000);
        System.out.println("userNameInputBox.isDisplayed() " +  userNameInputBox.isDisplayed());

        Assert.assertTrue(userNameInputBox.isDisplayed(), "the input box should be displayed");



        driver.quit();


    }
}
