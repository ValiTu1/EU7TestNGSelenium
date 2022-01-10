package com.cybertek.tests.weeklyTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsAndIframeExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void IFrameTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement preferences = driver.findElement(By.id("sn-b-custom"));

        wait.until(ExpectedConditions.visibilityOf(preferences)).click();

        driver.findElement(By.id("sn-b-save")).click();

        driver.switchTo().frame("iframeResult");

        Actions actions = new Actions(driver);
        String textXPath = "//p[contains(text(),'Double-click')]";

        WebElement pText = driver.findElement(By.xpath(textXPath));
        actions.moveToElement(driver.findElement(By.xpath(textXPath))).doubleClick().perform();
        Thread.sleep(1000);

        String expectedColor = "red";

        Assert.assertTrue(pText.getAttribute("style").contains(expectedColor));



    }

}
