package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

        /*
        * Verify confirmation message
        * go to http://practice.cybertekschool.com/forgot_password links to an external site
        * enter an email
        * verify that email is displayed in the input box
        * click on Retrieve password
        * verify that confirmation message says 'Your e-mail's been sent!'
        *
        * */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //open http://practice.cybertekschool.com/forgot_password website

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //finding email box
        WebElement emailBox = driver.findElement(By.name("email"));

        String expectedMail = "madalina_nebuna@crazy.com";

        //enter an email
        emailBox.sendKeys(expectedMail);

        Thread.sleep(1000);

        //checking the mail is displayed
        String actualEmail = emailBox.getAttribute("value");
        if(expectedMail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected email is: " + expectedMail);
            System.out.println("Actual email is: " + actualEmail);
        }

        //finding the retrieve button
        WebElement clickRetrieveButton = driver.findElement(By.id("form_submit"));

        //click on retrieve button
        clickRetrieveButton.click();

        Thread.sleep(5000);

        //finding the message box

        WebElement confirmation = driver.findElement(By.name("confirmation_message"));

        //verifying confirmation message
        String expectedMessage = "Your e-mail's been sent!";

        String actualMessage = confirmation.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected message is: " + expectedMessage);
            System.out.println("Actual message is: "+ actualMessage);
        }

        driver.quit();








    }
}
