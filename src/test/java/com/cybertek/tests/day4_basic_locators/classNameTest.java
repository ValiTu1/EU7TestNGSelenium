package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement homeLink = driver.findElement(By.className("nav-link"));

        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement multipleButtons = driver.findElement(By.className("h3"));
        String name = multipleButtons.getText();

        //driver.findElement(By.className("h3")).getText();

        System.out.println(name);



    }
}
