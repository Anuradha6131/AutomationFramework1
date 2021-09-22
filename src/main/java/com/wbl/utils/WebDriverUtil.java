package com.wbl.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.awt.geom.AreaOp;

public class WebDriverUtil {

    private static Logger log= LogManager.getLogger("WebDriverUtil.class");

    //Factory design pattern
    //tutorialpoint.com
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;

        try{
            log.info("browserName "+browserName);
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.RESOURCES_PATH + "/drivers\\chromedriver.exe");
                //return implementation classes here like chromedriver,firefoxdriver etc..
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver", Constants.RESOURCES_PATH + "/drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", Constants.RESOURCES_PATH + "/drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
        }

        }
        catch(Exception e){

            log.error("There is an exception when creating webdriver object");
            log.error(e.getStackTrace());

            }
        return driver;
    }
}
