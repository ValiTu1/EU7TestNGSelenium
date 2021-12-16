package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){

        System.out.println("First Asserttion");
        Assert.assertEquals("Title","Title");

        Assert.assertEquals("url", "url");
        System.out.println("Second Assertion");

    }

    @Test
    public void test2(){
        Assert.assertEquals("test2", "test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actulTitle = "Cybertek";

        Assert.assertTrue(actulTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }

    @Test
    public void test4(){
        //verify email contains "@" sign

        String email = "email@With.google.com";
        String sign = "@";

        Assert.assertTrue(email.contains(sign),"checking email contains @ sign");
    }

    @Test
    public void test5(){

        Assert.assertFalse(0>1, "Verify that 0 is not grater than 1");

    }

    @Test
    public void test6(){

        Assert.assertNotEquals("one", "one");
    }



}
