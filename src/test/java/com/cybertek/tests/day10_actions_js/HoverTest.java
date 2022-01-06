package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    Hover over each image in the website
    verify each name: user text is displayed

     */

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("images.size() = " + images.size());

        List<WebElement> imagesText = driver.findElements(By.xpath("//div/h5"));

        Actions actions = new Actions(driver);

        for(int i=0;i< images.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(images.get(i)).perform();

            String expectedText = "name: user" + (i+1);

            String actualText = imagesText.get(i).getText();

            Assert.assertEquals(actualText, expectedText," verify text displayed");


        }


    }

}
