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
import java.util.Locale;

public class SelectDropDownTest {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        //locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);
        List<WebElement> options = stateDropdown.getOptions();

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        //locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is Select a state

        String selectedOption = "Select a state";
        String actualOption = stateDropdown.getFirstSelectedOption().getText().toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualOption, selectedOption.toLowerCase(Locale.ROOT), "verify first selection");

        //how to select something from dropdown

        //stateDropdown.selectByIndex(0);
        //stateDropdown.selectByValue("Virginia");
        stateDropdown.selectByVisibleText("Virginia");

        String expectedText = "Virginia";

        String actualText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualText, expectedText,"Checking is selected option is Virginia");


        //SELECT USING INDEX
        stateDropdown.selectByIndex(51);

        String expectedResult = "Wyoming";
        String actualResult = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedResult,actualResult,"Checking for equality");

        //SELECT USING VALUE

        stateDropdown.selectByValue("TX");

        String expectedText2 = "Texas";
        String actualText2 = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedText2,actualText2,"checking the equality");







    }
}
