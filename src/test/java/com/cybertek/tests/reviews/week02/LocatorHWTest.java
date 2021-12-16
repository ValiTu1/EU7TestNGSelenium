package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class LocatorHWTest {

    /*
    *
    *
    * Test case
            Go to Ebay
            search Selenium
            click on search button
            print number of results
            verify title contains Selenium*/

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        WebElement searchBar = driver.findElement(By.id("gh-ac"));

        String expectedSearchItem = "Selenium";

        searchBar.sendKeys(expectedSearchItem);

        Thread.sleep(2000);

        WebElement clickSearch = driver.findElement(By.id("gh-btn"));

        clickSearch.click();

        WebElement results = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span"));


        System.out.println("results = " + results.getText());

        if(driver.getTitle().toLowerCase().contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();



    }


}
