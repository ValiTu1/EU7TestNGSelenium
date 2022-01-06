package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

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

    @Test
    public void clickWithJS(){

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);

    }

    @Test
    public void typeWithJS(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.xpath("//form/input"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String text =  "Hello disabled input";

        js.executeScript("arguments[0].value=" + "'" + text + "'", inputBox);

    }

    @Test
    public void ScrollUpAndDown() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse =  (JavascriptExecutor) driver;

        // This  will scroll page 400 pixel vertical


        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }

    @Test

    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement englishDropDown = driver.findElement(By.xpath("//a[@id='icp-touch-link-language']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);", englishDropDown);

        Thread.sleep(2000);

    }

}
