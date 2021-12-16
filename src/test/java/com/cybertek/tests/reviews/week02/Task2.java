package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {

    /*
    * go to https://www.demoblaze.com/index.html#
    Navigate to Laptops Category
    Then Sony vaio i7 laptop
    Verify the product price is 790 Dollars*/

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/index.html#");

        WebElement laptopsElement = driver.findElement(By.partialLinkText("Laptops"));
        laptopsElement.click();
        Thread.sleep(2000);

        WebElement sony7 = driver.findElement(By.partialLinkText("i7"));

        sony7.click();

        Thread.sleep(1000);

        WebElement laptopPrice = driver.findElement(By.xpath("//h3[@class='price-container']"));

        String[] value = laptopPrice.getText().split(" ");

        int expectedResut = 790;

        System.out.println(value[0]);

        if(Integer.valueOf(value[0].substring(1)) == expectedResut){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
