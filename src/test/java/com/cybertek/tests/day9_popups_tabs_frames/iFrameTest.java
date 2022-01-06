package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {

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
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendKeys
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith");
        Thread.sleep(2000);

        //goes back to first frame(main html)
        //goes back to first frame, usefull when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2. Switching with index
        driver.switchTo().frame(0);// counting starts from first iframe(0, 1, 2....)
        //clear before sendKeys
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith with index");
        Thread.sleep(2000);

        //2nd way of switching parent
        driver.switchTo().parentFrame();

        //3. Using web element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Mike Smith with web element");
        Thread.sleep(2000);

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");

        //frame top has three child frames left, middle and right
        driver.switchTo().frame("frame-middle");

        //driver.switchTo().frame(0).switchTo().frame(1);
        System.out.println("Middle frame text: " + driver.findElement(By.id("content")).getText());

        //switching to right frame from frame top
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //switching to frame-bottom

        //first switch to default frame
        driver.switchTo().defaultContent();
        //now switch to frame bottom
        driver.switchTo().frame(1);
        System.out.println("Text for bottom frame is = " + driver.findElement(By.tagName("body")).getText());
    }
}
