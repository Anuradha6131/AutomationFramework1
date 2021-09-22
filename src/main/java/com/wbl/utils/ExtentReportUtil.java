package com.wbl.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {



    public static ExtentReports getExtentReports(){

        String path = System.getProperty("user.dir")+"\\reports\\extent-report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Anu");
        return extent;
    }

//    @Test
//    public void initialDemo(){
//        extent.createTest("ExtentReport");
//
//        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.kohls.com/");
//        System.out.println(driver.getTitle());
//        extent.flush();
//    }

}


