package com.wbl.utils;

import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerListener extends TestListenerAdapter {
    Logger logger = LogManager.getLogger(LoggerListener.class);


    @Override
    public void onTestStart(ITestResult tr) {
        logger.info("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        logger.info("Test '" + tr.getName() + "' PASSED");

        // This will print the class name in which the method is present
        logger.info(tr.getTestClass());

        // This will print the priority of the method.
        // If the priority is not defined it will print the default priority as
        // 'o'
        logger.info("Priority of this method is " + tr.getMethod().getPriority());

    }

    @Override
    public void onTestFailure(ITestResult tr) {

        logger.info("Test '" + tr.getName() + "' FAILED");
        logger.info("Priority of this method is " + tr.getMethod().getPriority());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {

        logger.info("Test '" + tr.getName() + "' SKIPPED");
    }


}

