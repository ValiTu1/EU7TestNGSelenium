package com.cybertek.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {


    @Test
    public void test1(){
        System.out.println("first Test Case");
    }

    //@Ignore
    @Test
    public void test2(){
        System.out.println("second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method");
        System.out.println("WebDriver Opening Browser");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
        System.out.println("Closing Browser, Quit");

    }



    @BeforeClass
    public void setUpClass(){

        System.out.println("--Before class--");
        System.out.println("executed one time before the class");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("--AFTER CLASS");
        System.out.println("Some reporting code here");
    }


}
