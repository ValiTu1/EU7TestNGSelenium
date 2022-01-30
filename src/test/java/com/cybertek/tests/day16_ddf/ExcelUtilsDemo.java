package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    @Test
    public void readExcelFile(){

    //create object from ExcelUtil
        // it accepts 2 arguments
        //Argument1: location of the file(path)
        //Argument2: sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        //how many rows are in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        /*for (Map<String, String> oneROw : dataList) {
            System.out.println(oneROw);

        }*/

        //get Nona as a value
        System.out.println("dataList.get(3).get(\"firstname\") = " + dataList.get(2).get("firstname"));

        // get Harber as result
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));

        //get all data in 2D array

        String[][] data = qa3short.getDataArray();

        //print 2D array
        System.out.println(Arrays.deepToString(data));


    }
}
