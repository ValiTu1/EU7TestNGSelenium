package com.cybertek.tests.reviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_YahooPractice {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");

        String expectedTitle = "Yahoo";

        if(driver.getTitle().equalsIgnoreCase(expectedTitle)){
            System.out.println("Titles are matching");
        }else{
            System.out.println("Titles are  not matching");
        }

        driver.close();


    }
}
