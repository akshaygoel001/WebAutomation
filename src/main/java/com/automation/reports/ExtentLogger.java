package com.automation.reports;

import com.automation.driver.DriverManager;
import com.automation.utils.ReadConfigPropertiesFile;
import com.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message) throws IOException {
        boolean screenshotEnable=ReadConfigPropertiesFile.getValue("PASSSTEPSCREENSHOT").equalsIgnoreCase("yes")?true:false;
        if(screenshotEnable){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image(),"Pass Screenshot").build());
        }
        else {
            ExtentManager.getExtentTest().pass(message);
        }

    }
    public static void fail(String message) throws IOException {
        boolean screenshotEnable=ReadConfigPropertiesFile.getValue("FAILSTEPSCREENSHOT").equalsIgnoreCase("yes")?true:false;
        if(screenshotEnable){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image(),"Error Screenshot").build());
        }
        else {
            ExtentManager.getExtentTest().fail(message);
        }
    }
    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }
    public static void skip(String message) throws IOException {
        boolean screenshotEnable=ReadConfigPropertiesFile.getValue("SKIPSTEPSCREENSHOT").equalsIgnoreCase("yes")?true:false;
        if(screenshotEnable){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            ExtentManager.getExtentTest().skip(message);
        }
    }




}
