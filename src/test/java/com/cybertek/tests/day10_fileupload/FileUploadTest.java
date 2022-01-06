package com.cybertek.tests.day10_fileupload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //choose file location of the file using Shift + Right CLick on file and select copy as path
        chooseFile.sendKeys("C:/Users/Madalina/Desktop/file.txt");
        //chooseFile.click();


        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(2000);

    }
}
