package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        Thread.sleep(2000);

        //click no element
        driver.findElement(By.xpath("//button[.='Delete']")).click();
        driver.findElement(By.xpath("//button[.='No']"));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[2]")).click();
        alert.dismiss();

        //click on button 3 and sendKeys
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Mike Smith");
        //click OK
        alert.accept();
    }
}
