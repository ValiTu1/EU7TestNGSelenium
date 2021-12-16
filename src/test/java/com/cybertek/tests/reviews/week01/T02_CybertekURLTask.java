package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_CybertekURLTask {



    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com");

        driver.manage().window().maximize();

        String stringToCheck = "cybertekschool";

        String strPractice = "Practice";

        if(driver.getCurrentUrl().contains(stringToCheck)){
            System.out.println("the URL contains " + stringToCheck);
        }else{
            System.out.println("the URL does not contains " + stringToCheck);
        }

        if(driver.getTitle().contains(strPractice)){
            System.out.println("The title contains" + strPractice);
        }else{
            System.out.println("The title does not contains " + strPractice);
        }

        driver.close();
    }

}
