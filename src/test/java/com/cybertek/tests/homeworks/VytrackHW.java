package com.cybertek.tests.homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackHW extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        extentLogger = report.createTest("Verify options is displayed");


        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login in the application");
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to Calendar Events module");
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.waitUntilLoaderScreenDisappear();
        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify if options is displayed on the page");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.options.isDisplayed());

        extentLogger.info("Verify if page number is 1");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), "1");

        extentLogger.info("Verify view per page is 25");
        Assert.assertTrue(calendarEventsPage.viewPerPage.getText().contains("25"));

        /*calendarEventsPage.viewPerPage.click();
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.viewPerPageOptions.get(3)));
        calendarEventsPage.viewPerPageOptions.get(3).click();*/

        //Verify that number of calendar events (rows in the table) is equals to number of records

        int actualNumberOfRows = 0;
        for(int i=1;i<=calendarEventsPage.getnumberOfPages();i++){
            actualNumberOfRows += calendarEventsPage.tableRows.size();
            calendarEventsPage.nextBtn.click();
            Thread.sleep(1000);
        }
        Assert.assertEquals(actualNumberOfRows, calendarEventsPage.getnumberOfRecords());


        extentLogger.pass("PASSED");

    }


}
