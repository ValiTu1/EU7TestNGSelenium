package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("John"));


    }

    @Test
    public void getAllHeaders(){
        //how many columns we have?

        List<WebElement> elements = driver.findElements(By.xpath("//table[1]//th"));


        System.out.println("There are " + elements.size() + " columns in the table");

        //print each element of the table

        for (WebElement element : elements) {

            System.out.println(element.getText());
        }

    }

    @Test
    public void printTableSize(){
        //how many columns we have?
        List<WebElement> elements = driver.findElements(By.xpath("//table[1]//th"));


        System.out.println("There are " + elements.size() + " columns in the table");

        //number of rows

        List<WebElement> rowswithHeader = driver.findElements(By.xpath("//table[1]//tr"));

        System.out.println("rowswithHeader.size() = " + rowswithHeader.size());

        //number of rows without header

        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[1]/tbody/tr"));

        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());
    }

    @Test
    public void getRow(){
        //print the second row information





        WebElement secondRow = driver.findElement(By.xpath("//table[1]/tbody/tr[2]"));

        System.out.println("secondRow.getText() = " + secondRow.getText());

        //get all rows dinamically

        //number of rows without header

        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[1]/tbody/tr"));

        for(int i=1;i<=rowsWithoutHeader.size();i++){

            String eachRow = "//table[1]/tbody/tr["+i+ "]";

            WebElement rows = driver.findElement(By.xpath(eachRow));

            System.out.println("Row " + i + ": " + rows.getText());

        }

        //loop shorcuts iter and itar

    }

    @Test
    public void printAllAcellInOneRow(){

        List<WebElement> allCells = driver.findElements(By.xpath("//table[1]/tbody/tr[1]/td"));

        for (WebElement each : allCells) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void getASingleCellByIndex(){
        String oneCell = driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td[5]")).getText();

        System.out.println(oneCell);
    }

    @Test
    public void printAllCellsByIndex(){

        int allRows = driver.findElements(By.xpath("//table[1]/tbody/tr")).size();

        int allColumns = driver.findElements(By.xpath("//table[1]/thead//th")).size();
        //System.out.println(allRows);
        //System.out.println(allColumns);

        //iterate through each row in the table
       for(int i=1;i<=allRows;i++){

           //iterate through each cell in the rows
            for(int j=1;j<=allColumns;j++){
                System.out.println(driver.findElement(By.xpath("//table[1]/tbody/tr[" + i+ "]/td["+j +"]")).getText());
            }

           System.out.println();
        }
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "Jason";

        String xpath = "//table[@id='table1']//td[.='"+ firstName + "']/../td[3]";

        WebElement email = driver.findElement(By.xpath(xpath));

        System.out.println(email.getText());

    }
}
