package com.cybertek.tests.day10_fileupload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){
        //C:\Users\Madalina\IdeaProjects\EU7TestNGSelenium\src\test\resources\textfile.txt
        //System.out.println(System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");

        System.out.println("projectPath = " + projectPath);
        String filePath = "\\src\\test\\resources\\textfile.txt";

        String fullPath = projectPath + filePath;

        System.out.println(fullPath);
    }
}
