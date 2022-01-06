package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window= " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("New title = " + driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle);

            }
            System.out.println("New title = " + driver.getTitle());
        }

    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window= " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        String expectedTitle = "New Window";

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            //switch one by one
            driver.switchTo().window(handle);

            //whenver your title equals to your expected window title
            if(driver.getTitle().equals(expectedTitle)){
                //stop on that window
                break;
            }

        }

        System.out.println("Title after new window = " + driver.getTitle());
    }
}
