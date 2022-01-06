package com.cybertek.tests.da7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class checkBoxHW {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        usernameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
    }


    @Test
    public void checkAll() throws InterruptedException {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        WebElement idAttribute;
        for (int i = 2; i < 10; i++) {

            idAttribute = driver.findElement(By.id(("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")));
            Assert.assertTrue(idAttribute.isSelected());
        }

    }
    @Test
    public void uncheckAll() throws InterruptedException {
        checkAll();
        WebElement idAttribute;

        WebElement uncheckButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckButton.click();


        for (int i = 2; i < 10; i++) {
            idAttribute = driver.findElement(By.id(("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")));
            Assert.assertFalse(idAttribute.isSelected());
        }
    }

    @Test
    public void deleteAPerson() throws InterruptedException {

        String name = "Steve Johns";

        String idValue = "ctl00_MainContent_orderGrid_ctl07_OrderSelector";

        WebElement deletedPerson = driver.findElement(By.id(idValue));
        deletedPerson.click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        Assert.assertNotEquals(deletedPerson, driver.findElement(By.id(idValue)));

        ArrayList<String> names = new ArrayList<>();
        for (int i=1; i<=7; i++) {
            String nameText = driver.findElement(By.xpath("//tr["+(i+1)+"]/td[2]")).getText();
            names.add(nameText);
        }
        Assert.assertFalse(names.contains(name));

    }

    @AfterMethod
    public void endingTest() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();

    }
}