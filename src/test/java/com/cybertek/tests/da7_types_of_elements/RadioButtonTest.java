package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.cssSelector("#blue"));

        WebElement redButton = driver.findElement(By.cssSelector("#red"));


        Assert.assertTrue(blueButton.isSelected(), "checking if blue button is selected");
        Assert.assertFalse(redButton.isSelected(), "checking if red button is not selected");

        //how to click radio button
        //clicking red radio button
        redButton.click();

        //blue -->false
        Assert.assertFalse(blueButton.isSelected(), "checking if blue button is NOT selected");
        //red --> true
        Assert.assertTrue(redButton.isSelected(), "checking if red button is selected");


        //Thread.sleep(2000);

        Assert.assertTrue(redButton.isSelected());

        driver.quit();
    }
}
