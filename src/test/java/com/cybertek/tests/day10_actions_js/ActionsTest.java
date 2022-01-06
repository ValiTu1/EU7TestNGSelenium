package com.cybertek.tests.day10_actions_js;

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

public class ActionsTest {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));

        //Actions class that contains all the user interactions
        //how to create actions object --> passing driver as constructor
        Actions actions = new Actions(driver);

        //perform --> performs the action, complete the action
        //moveToElement --> move your element to WebElement(hover over)
        actions.moveToElement(img1).perform();

        WebElement nameIsDisplayed = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[1]"));

        WebDriverWait wait = new WebDriverWait(driver, 10 );

        wait.until(ExpectedConditions.visibilityOf(nameIsDisplayed));

        Assert.assertTrue(nameIsDisplayed.isDisplayed(), "verify name is diplayed");






    }

    @Test

    public void DragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement cookies = driver.findElement(By.xpath("//*[.='Change Settings']"));

        wait.until(ExpectedConditions.visibilityOf(cookies));

        cookies.click();
        Thread.sleep(1000);

        WebElement cookies2 = driver.findElement(By.xpath("//*[.='Save Settings']"));

        wait.until(ExpectedConditions.visibilityOf(cookies2));

        cookies2.click();

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        wait.until(ExpectedConditions.visibilityOf(sourceElement));

        Thread.sleep(2000);

        Actions action = new Actions(driver);

        action.dragAndDrop(sourceElement, targetElement).perform();

        Thread.sleep(2000);
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {


        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement cookies = driver.findElement(By.xpath("//*[.='Change Settings']"));

        wait.until(ExpectedConditions.visibilityOf(cookies));

        cookies.click();
        Thread.sleep(1000);

        WebElement cookies2 = driver.findElement(By.xpath("//*[.='Save Settings']"));

        wait.until(ExpectedConditions.visibilityOf(cookies2));

        cookies2.click();

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droptarget"));

        wait.until(ExpectedConditions.visibilityOf(sourceElement));

        Thread.sleep(2000);

        Actions action = new Actions(driver);

        action.moveToElement(sourceElement).clickAndHold().moveToElement(targetElement).release(targetElement).perform();

        //action.dragAndDrop(sourceElement, targetElement).perform();

        Thread.sleep(2000);


    }
}
