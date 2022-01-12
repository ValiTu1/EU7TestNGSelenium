package com.cybertek.tests.weeklyTasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
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
*
*
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
*
*
* HW: finish the task by returning deleted product price
* capture expectedPurchaseAmount dynamically
*
* DO the rest of the task, use Faker class for the form
• Click on "Ok"*/

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    int expectedAmount = 0;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void navigateTo(String str){
        driver.findElement(By.partialLinkText(str)).click();

    }

    public int productAdder(String category, String product){
        navigateTo(category);
        WebDriverWait wait = new WebDriverWait(driver,10);

        navigateTo(product);

        //I want to get my expected price for that product
        String value = driver.findElement(By.tagName("h3")).getText();
        String[] arr =value.split(" ");
        int listPrice = Integer.parseInt(arr[0].substring(1));

        navigateTo("Add to cart");


        //handle pop up

        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();

        alert.accept();

        navigateTo("Home");

        return listPrice;
    }

    public void fillInputs(String idValue, String details) throws InterruptedException {

        driver.findElement(By.id(idValue)).sendKeys(details);
        Thread.sleep(500);
    }


    public int productRemover(String product){

        //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
        navigateTo("Cart");

        WebElement productPrice= driver.findElement(By.xpath("//tr[contains(.,'"+ product +"')]/td[3]"));

        int elementPrice = Integer.parseInt(productPrice.getText());

        WebElement deleteButton = driver.findElement(By.xpath("//tr[contains(.,'"+ product +"')]/td[4]/a"));
        deleteButton.click();


        //String xPath = "//tr[contains(.,'"+ product +"')]/td[4]/a";

        //driver.findElement(By.)

        return elementPrice;

    }

    @Ignore
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
        expectedAmount += productAdder("Laptops", "Sony vaio i5");


        //Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        expectedAmount += productAdder("Laptops", "Dell i7 8gb");


        expectedAmount -= productRemover("Sony");

        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        fillInputs("name", "Mike Smith");
        fillInputs("country", "Uk");
        fillInputs("city", "London");
        fillInputs("card", "01234 5678 9012 3456");
        fillInputs("month", "10");
        fillInputs("year", "2022");
        Thread.sleep(2000);

        WebElement purchaseButton = driver.findElement(By.xpath("//button[.='Purchase']"));
        purchaseButton.click();

        Thread.sleep(1000);

        WebElement purchaseConfirmation = driver.findElement(By.xpath("//p[contains(.,'USD')]"));

        String[] arrPurchase = purchaseConfirmation.getText().split(" USD");
        String[] arrPurchase2 = arrPurchase[0].split("Amount: ");
        int actualValue = Integer.parseInt(arrPurchase2[1]);


        Assert.assertEquals(actualValue, expectedAmount);


        driver.findElement(By.xpath("//*[contains(text(),'OK')]")).click();



    }


}
