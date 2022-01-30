package com.cybertek.tests.reviews.week7;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HWTest extends TestBaseHW{

    @Test
    public void verifyOptionsTest(){

        extentLogger = report.createTest("Verify Options Link");
        extentLogger.info("Preconditions loaded");

        extentLogger.info("Verify Options link is displayed");
        Assert.assertTrue(page.options.isDisplayed(), "options link is NOT displayed");

        extentLogger.pass("Options is displayed");


    }

    @Test
    public void verifyPageNumber(){
        extentLogger = report.createTest("Verify page number");
        Assert.assertEquals(page.pageNumber.getAttribute("value"), "1" ,"page number is NOT equal to 1");
        extentLogger.pass("Page number verified");
    }

    @Test
    public void verifyViewPerPage(){

        extentLogger = report.createTest("Verify View Per Page Test");
        wait.until(ExpectedConditions.elementToBeClickable(page.viewPerPage));
        int viewPerPage = Integer.parseInt(page.viewPerPage.getText().trim());
        Assert.assertEquals(viewPerPage, 25, "view per page is NOT equal to 25");
    }
}
