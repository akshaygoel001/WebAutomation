package com.automation.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {
    private ExtentManager(){}
    private static ThreadLocal<ExtentTest> extTest=new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extTest.get();
    }
    public static void setExtTest(ExtentTest test) {
        extTest.set(test);
    }
    static void unload() {
        extTest.remove(); // Compliant
    }

}
