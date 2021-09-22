package com.wbl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    //make it final the variable
    //public static Properties prop;
    public static final Properties prop = new Properties();
    //properties class is used to read the property file            q
//below is basically load/read the file
    //instead of writing a method write the constructor(for the method we have to call again and again

    // public static Properties getPropertyObject(String fileName){

    public ConfigUtil(String fileName) {

        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
