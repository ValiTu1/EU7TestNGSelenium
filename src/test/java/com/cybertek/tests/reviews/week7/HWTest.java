package com.cybertek.tests.reviews.week7;

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
}
