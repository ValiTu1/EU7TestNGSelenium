package com.cybertek.tests.reviews.week7;

import com.cybertek.utilities.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelTestExamples {

    //How to read from an excel file
    //how to create an excel file

    List<Map<String, String>> users = new ArrayList<>();


    @Test
    public void createExcelFile() throws Exception {

        ExcelUtil readFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        int rowCount = readFile.rowCount();// gives how many rows I have
        for(int i=1; i< rowCount;i++){
            Map<String, String> userDataOfEachRow = new HashMap<>();
            String userName = readFile.getCellData(i, 0);//retturns cell information
            String password = readFile.getCellData(i, 1);
            String firstName = readFile.getCellData(i, 2);
            String lastName = readFile.getCellData(i, 3);
            userDataOfEachRow.put(readFile.getColumnsNames().get(0), userName);// This will return column names in a List format
            // so I have to give index
            userDataOfEachRow.put(readFile.getColumnsNames().get(1), password);
            userDataOfEachRow.put(readFile.getColumnsNames().get(2), firstName);
            userDataOfEachRow.put(readFile.getColumnsNames().get(3), lastName);

            users.add(userDataOfEachRow);
        }

        System.out.println(users);

        System.out.println(users.get(5).get("firstname"));//points to line 7, gives the 6th person


        //create and object from WorkBook class to create an excel file
        Workbook workbook = new HSSFWorkbook();

        //create a sheet with the specified name
        Sheet sheet = workbook.createSheet("MyUsers");

        //creating the header names
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < readFile.columnCount(); i++) {
            Cell cell = headerRow.createCell(i); //create a cell
            cell.setCellValue(readFile.getColumnsNames().get(i)); // put data in the cell
        }

        for (int i = 1; i < readFile.rowCount()-1; i++) {
             Row eachRow = sheet.createRow(i);
             eachRow.createCell(0).setCellValue(users.get(i-1).get("username"));
             eachRow.createCell(1).setCellValue(users.get(i-1).get("password"));
             eachRow.createCell(2).setCellValue(users.get(i-1).get("firstname"));
             eachRow.createCell(3).setCellValue(users.get(i-1).get("lastname"));

        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/MyUsers.xlsx");

        workbook.write(fileOutputStream);
        workbook.close();

        //3 more weeks for UI automation
        //2 weeks for database
        //3 weeks for API(Mobile Testing as optional videos)



    }







}
