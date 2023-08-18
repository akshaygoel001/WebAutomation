package com.automation.tests;

import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.reports.ExtentLogger;
import com.automation.utils.ReadConfigPropertiesFile;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends Base {

    @Parameters({"browser"})
    @Test(enabled = true)
    public void validLogin(String browser) throws IOException {
        System.out.println(browser+" -> Page Title is: "+DriverManager.getDriver().getTitle());
        ExtentLogger.info("Test starts in browser "+browser);
        new LoginPage()
                .setUserName(WaitStrategy.VISIBLE, ReadConfigPropertiesFile.getValue("USERNAME"))
                .setPassword(WaitStrategy.VISIBLE, ReadConfigPropertiesFile.getValue("PASSWORD"))
                .doSubmit(WaitStrategy.VISIBLE);
        Assert.assertEquals(new HomePage().getTitle(WaitStrategy.VISIBLE,"dashboard"), ReadConfigPropertiesFile.getValue("HOMEPAGETITLE"));
    }
}
