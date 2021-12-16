package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {



        /*
        * Verify URL changed
        * open chrome browser
        * go to http://practice.cybertekschool.com/forgot_password links to an external site
        * enter an email
        * click on Retrieve password
        * verify that url changed to http://practice.cybertekschool.com/email_sent
        * */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //get initial url
        driver.getCurrentUrl();

        //locate email box

        WebElement getEmailElement = driver.findElement(By.name("email"));

        //sendKeys() --> sends keyboar action to the WebElement
        getEmailElement.sendKeys("smecher@yahoo.com");
        Thread.sleep(2000);

        WebElement clickRetrievePassword = driver.findElement(By.id("form_submit"));
        clickRetrievePassword.click();

        Thread.sleep(1000);

        //get new url
        String actualURL = driver.getCurrentUrl();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        if(actualURL.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close browser
        driver.quit();







    }

}
