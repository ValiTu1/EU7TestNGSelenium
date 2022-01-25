package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    @Test
    public void test1(){

        /*
        * Test case
        * Open browser
        * Login as a Driver
        * Verify that page subtitle is Quick Events
        * Go to Activities -> Calendar Events
        * verify that page subtitle is Calendar Events
        *
        * */

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashBoardPage dashBoardPage = new DashBoardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle  = dashBoardPage.getPageSubTitle();
        dashBoardPage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals(actualSubtitle,expectedSubtitle, "checking for displayed subtitle");


        dashBoardPage.navigateToModule("Activities", "Calendar Events");
        //dashBoardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events", "Verify subtitle" );
    }

}
