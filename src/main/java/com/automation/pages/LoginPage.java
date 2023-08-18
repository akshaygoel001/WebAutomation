package com.automation.pages;

import com.automation.enums.WaitStrategy;
import com.automation.listeners.TestListener;
import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.io.IOException;

public class LoginPage extends BasePage{

    private By userName= By.name("username");

    private By passWord=By.name("password");

    private By submitButton=By.xpath("//button[@type='submit']");


    public LoginPage setUserName(WaitStrategy waitStrategy,String value) throws IOException {
        sendKeys(waitStrategy,userName, value);
        ExtentLogger.pass("Username entered successfully");
        return this;
    }
    public LoginPage setPassword(WaitStrategy waitStrategy,String value) throws IOException {
        sendKeys(waitStrategy,passWord,value);
        ExtentLogger.pass("Password entered successfully");
        return this;
    }
    public void doSubmit(WaitStrategy waitStrategy) throws IOException {
        click(waitStrategy,submitButton);
        ExtentLogger.pass("Submit button clicked successfully");
    }
}
