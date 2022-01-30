package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownELement = driver.findElement(By.id("dropdownMenuLink"));

        //click the dropdown to see available options
        dropdownELement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector(".dropdown-menu.show>a"));

        System.out.println("elements.size() = " + dropdownOptions.size());
       Assert.assertEquals(dropdownOptions.size(),5,"verify size of options");

        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());
        }

        dropdownOptions.get(2).click();

        Thread.sleep(5000);


        /*for (WebElement option : dropdownOptions) {
            if(option.getText().equals("Yahoo")){
                option.click();
            }
        }*/


    }

}
