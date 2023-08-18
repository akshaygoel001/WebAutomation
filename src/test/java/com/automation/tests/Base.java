package com.automation.tests;

import com.automation.driver.DriverFactory;
import com.automation.reports.ExtentLogger;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Arrays;

public class Base {
    protected Base() {
    }

    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        DriverFactory.initDriver(data[0].toString());

    }
    @AfterMethod
    protected void tearDown(){
        DriverFactory.quitDriver();
    }
}
