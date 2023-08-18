package com.automation.reports;

import com.automation.constants.FrameworkConstants;
import com.automation.utils.ReadConfigPropertiesFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    public static ExtentReports extent;

    public static ExtentReport initReport() throws IOException {
        if(Objects.isNull(extent)){
            extent=new ExtentReports();
            ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("OrangeHRM Automation Report");
            spark.config().setReportName(ReadConfigPropertiesFile.getValue("REPORTNAME"));
        }
        return new ExtentReport();
    }
    public static ExtentReport flushReport(){
        if (Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
        return new ExtentReport();
    }
    public void openReport() throws IOException {
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
    }
}
