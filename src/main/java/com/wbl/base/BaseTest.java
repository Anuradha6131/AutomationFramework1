package com.wbl.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wbl.utils.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;
    protected static String url;
    protected static String browser;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;

   @BeforeSuite
   public void beforeSuite(){
       ConfigUtil configutil = new ConfigUtil(Constants.RESOURCES_PATH + "/config.properties");
       url = configutil.getProperty("stageUrl");
       browser = configutil.getProperty("browser");

       extentReports= ExtentReportUtil.getExtentReports();
   }

    @BeforeMethod
    public void setup(ITestResult result) {

        extentTest=extentReports.createTest(result.getMethod().getMethodName());

        extentTest.log(Status.INFO,"ExtentReport Test started");

        driver = WebDriverUtil.getDriver(browser);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }


    @AfterMethod
    public void tearDown(ITestResult rs) {

       if(ITestResult.FAILURE==rs.getStatus()){

           ScreenshotUtil.takeScreenshot(rs.getName(),driver);
           extentTest.log(Status.FAIL,"Test Failed "+rs.getName());


       }
       if(ITestResult.SUCCESS==rs.getStatus()){
           extentTest.log(Status.PASS,"Test Passed "+rs.getName());
       }
       driver.quit();
       extentReports.flush();

    }


}
