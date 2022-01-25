package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {


    /*
     *
     * Open browser
     * Login as driver
     * Go to Activities-> Calendar Events
     * CLick on create calendar events
     * Click on repeat
     * Verify that repeat every day is checked
     * verity that repeat weekday is not checked
     *
     * */

    @Test
    public void test1(){


        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashBoardPage dashBoardPage = new DashBoardPage();
        //Go to Activities-> Calendar Events
        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        //CLick on create calendar events
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        //Click on repeat
        actions.moveToElement(createCalendarEventsPage.repeat).perform();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every day is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

        //verity that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());

    }


    @Test
    public void test2(){

        /*
        * Open browser
        * Login as driver
        * Go to Activities -> Calendar Events
        * Click on create calendar events button
        * Click on repeat checkbox
        * Verify that repeat options are Daily, Weekly, Monthly, Yearly(in this order)
        *
        * */

        //Login as driver
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        //Go to Activities -> Calendar Events
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        //Click on create calendar events button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat checkbox
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat options are Daily, Weekly, Monthly, Yearly(in this order)

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        Select select = createCalendarEventsPage.repeatOptionsList();

        List<String> actualList = new ArrayList<>();
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            actualList.add(option.getText());
        }

            Assert.assertEquals(actualList,expectedList);


    }


}
