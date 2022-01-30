package com.cybertek.tests.reviews.week7;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseHW {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    //Reporting with Extent Reports
    //Stept1: Get the dependency;
    //Stept2: Create object building the report

    //STept3: create another object for HTML report file

    //for extent report methods
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    CalendarEventsPage page;

    @BeforeTest
    public void setUpTest(){
//initialize the object
        report = new ExtentReports();
//initialize the html reporter with the report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";
//attach the html report to report object
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        //title in report
        htmlReporter.config().setReportName("Vytrack Homework Test Cases");
        //set environment information
        report.setSystemInfo("Enrironment", "Test");
        report.setSystemInfo("Broser", ConfigurationReader.get("browser"));
        report.setSystemInfo("Operation system(OS)", System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUpEachCase() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

        new LoginPage().loginAsStoreManager();//Login as a store manager

        page = new CalendarEventsPage();
        page.navigateToModule("Activities", "Calendar Events");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus()== ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            extentLogger.fail(result.getThrowable());
        }/*else{// if you also want to get screenshot if scenario passes
            //record the name of passed test case
            extentLogger.pass(result.getName());
            //take the screenshot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
        }*/
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void fullTeadDown(){
        report.flush();
    }




}
