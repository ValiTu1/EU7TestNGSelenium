package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement getFullNameBox = driver.findElement(By.name("full_name"));


        getFullNameBox.sendKeys("Mike Smith");

        WebElement enterEmail = driver.findElement(By.name("email"));

        enterEmail.sendKeys("email.Mine@gmail.com");

        WebElement clickSignUp = driver.findElement(By.name("wooden_spoon"));

        clickSignUp.click();

        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();

        Thread.sleep(1000);

        WebElement clickHomeButton = driver.findElement(By.id("wooden_spoon"));

        clickHomeButton.click();
        Thread.sleep(1000);

        driver.quit();





    }
}
