package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderTwo {

    private static Properties properties; //declare an object



    static{

        String path = "configurationTwo.properties";

        try {
            properties = new Properties(); // created properties object
            FileInputStream file = new FileInputStream(path); // throws Java I/O exception

            properties.load(file);

            file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String get(String keyName){

        return properties.getProperty(keyName);
    }






}
