package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));


        //get the value of type attribute
        System.out.println(blueRadioButton.getAttribute("type"));

        //get the value of name attribute
        System.out.println(blueRadioButton.getAttribute("name"));

        //get the value of checked
        //since checked attribute does not keep any value it will return true or false based on the condition
        System.out.println(blueRadioButton.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non existing attribute it will return null to us
        System.out.println(blueRadioButton.getAttribute("href"));

        System.out.println(blueRadioButton.getAttribute("outerHTML"));


        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));

        String outerHTML = button2.getAttribute("outerHTML");




        System.out.println(button2.getAttribute("outerHTML"));
        System.out.println("Innner HTML: " + button2.getAttribute( "innerHTML"));

        driver.quit();

    }
}
