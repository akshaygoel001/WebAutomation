package com.automation.listeners;

import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentManager;
import com.automation.reports.ExtentReport;
import org.testng.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReport().openReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String[] browsers=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Parameters.class).value();
        for(String browser:browsers){
            System.out.println(browser);
        }

        ExtentManager.setExtTest(ExtentReport.extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentLogger.pass("Test passed successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail("Test failed with error :"+result.getThrowable().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
       //
    }

    @Override
    public void onFinish(ITestContext context) {

    }


}
