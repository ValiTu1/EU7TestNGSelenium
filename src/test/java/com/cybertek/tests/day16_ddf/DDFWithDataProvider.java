package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testdata(){

        String[][] data= {
                {"Person of Interest","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The office","8"},
                {"Friends","7"},
                {"Westworld","10"},
                {"Gotham","9"},
                {"Dark","8"}
        };
        return data;
    }

    @Test(dataProvider="testdata")
    public void test1(String tvShow, String rating){
        System.out.println("Tv show: " + tvShow + " has rating: " + rating);
    }

}
