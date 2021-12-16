package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes>[name=checkbox1]"));

        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes>[name=checkbox2]"));

        //how to check if checkbox2 is clicked

        System.out.println("checkbox2.isSelected(): " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected(): " + checkbox2.isSelected());


        Assert.assertFalse(checkbox1.isSelected(), "verify checkbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");


        checkbox1.click();
        Thread.sleep(1000);

        System.out.println("checkbox2.isSelected(): " + checkbox1.isSelected());

        Assert.assertTrue(checkbox1.isSelected(), "verify checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");

        checkbox1.click();
        Thread.sleep(1000);
        driver.quit();



    }

}
