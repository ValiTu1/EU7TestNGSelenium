package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA2-short");

        String[][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return  dataArray;

    }

    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstname, String lastname, String result){
        extentLogger = report.createTest("Test " + firstname + " " + lastname);
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login to the application using username= " + username + " and password= " + password);
        loginPage.login(username,password);

        DashBoardPage dashBoardPage = new DashBoardPage();

        dashBoardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashBoardPage.getUserName();
        String expectedFullName = firstname + " " + lastname;

        Assert.assertEquals(actualFullName,expectedFullName, "verify fullname");
        extentLogger.pass("PASSED");
    }

}
