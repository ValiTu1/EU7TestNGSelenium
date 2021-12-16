package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifiUrlNotChanged {

    public static void main(String[] args) {

        /*
        * Verify URL not changed
        * - open chrome broser
        * - go to http://practice.cybertekschool.com/forgot_password links to an external site
        * - click on Retrieve password
        * - verify that url did not change
        * */


        //open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //saving expected expected url before clicking button
        String expectedlURL = driver.getCurrentUrl();

        //click on Retrieve password
        //WebElement --> Interface that represents elements on the page
        //findElement --> method used to find element on a page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String actualURL = driver.getCurrentUrl();

        //verify url did not change

        if(expectedlURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close your browser
        driver.quit();







    }
}
