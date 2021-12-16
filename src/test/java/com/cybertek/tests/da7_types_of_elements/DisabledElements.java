package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.cssSelector(".radio #green"));


        //how to check any element is enabled of not
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());

        Assert.assertFalse(greenRadioButton.isEnabled());

        driver.quit();
    }


    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example input[type=text]"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button[type=button]"));



        //check if inputBox is enabled

        System.out.println("inputBox.isEnabled() " + inputBox.isEnabled());

        Assert.assertFalse(inputBox.isEnabled());

        //click on Enable button

        enableButton.click();

        Thread.sleep(3000);

        Assert.assertTrue(inputBox.isEnabled());

        driver.quit();
    }
}
