package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with Selenium

        //System.out.println(driver.getTitle());

        //shortcut for creating variable
        // Option or ALT + ENTER ENTER
        //getTitle() --> gets you the title of the page
        String title = driver.getTitle();

        //soutv + enter to print variable name and value
        System.out.println("title = " + title);


        //getCurrentUrl gets the current url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() --> gets the source of the page

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }
}
