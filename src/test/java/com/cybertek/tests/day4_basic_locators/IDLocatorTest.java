package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        // http://practice.cybertekschool.com/multiple_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //open the multiple buttons page
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        Thread.sleep(3000);

        //find the don't click button
        WebElement dontClickTutton = driver.findElement(By.id("disappearing_button"));

        //click on the button
        dontClickTutton.click();

        Thread.sleep(1000);

        driver.quit();




    }
}
