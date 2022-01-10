package com.cybertek.tests.weeklyTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoBlaze09012022 {

    /*
    * Adidas Company QA Test
You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"*/

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    public void navigateTo(String str){
        driver.findElement(By.linkText(str)).click();

    }

    public void productAdder(String category, String product){
        navigateTo(category);
        WebDriverWait wait = new WebDriverWait(driver,10);

        navigateTo(product);

        navigateTo("Add to cart");


        //handle pop up

        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();

        alert.accept();
    }

    public void fillInputs(String idValue){
        driver.findElement(By.id(idValue));
    }

    @Test
    public void test1() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);



        List<WebElement> productCategories = driver.findElements(By.xpath("//div[@class='list-group']/a"));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Samsung galaxy s6"))));

        for(int i=2;i<= productCategories.size();i++){
            String xPath = "//div[@class='list-group']/a["+ i +"]";
            driver.findElement(By.xpath(xPath)).click();
            Thread.sleep(1000);
        }

    }

    @Test
    public void purchaseLaptops() throws InterruptedException {

        //Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        productAdder("Laptops", "Sony vaio i5");

        //navigate back to Home page
        driver.findElement(By.partialLinkText("Home")).click();

        //Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        productAdder("Laptops", "Dell i7 8gb");

        //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
        navigateTo("Cart");
        navigateTo("Delete");

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        fillInputs("name");

        Thread.sleep(2000);
    }

    public void waitMethod(){
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();

        alert.accept();
    }

}
