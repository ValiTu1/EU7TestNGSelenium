package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    /*
    * TASK
    * go to amazon.com
    * search for selenium
    * click search button
    * 1-48 of 191 results for "selenium"
    *
    * */


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchResult = driver.findElement(By.xpath("//div/input[@id='twotabsearchtextbox']"));
        searchResult.sendKeys("selenium");

        WebElement lickSearch = driver.findElement(By.xpath("//input[@value='Go']"));
        lickSearch.click();

        Thread.sleep(2000);

        //WebElement getResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[@dir='auto']"));


        WebElement getResults = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        String result = getResults.getText();
        System.out.println(result);

        String expectedResult = "1-48 of 202 results for";

        if(expectedResult.equals(result)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }




        driver.quit();




    }
}
