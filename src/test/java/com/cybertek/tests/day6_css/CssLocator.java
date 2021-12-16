package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClick = driver.findElement(By.cssSelector("#disappearing_button"));

        String getText = dontClick.getText();
        System.out.println(getText);
        dontClick.click();


        driver.quit();



    }
}
