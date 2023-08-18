package com.automation.factories;

import com.automation.constants.FrameworkConstants;
import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {
    private ExplicitWaitFactory(){
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement element = null;
        if(waitStrategy.toString().equalsIgnoreCase("CLICKABLE")){
            element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittimeinsec()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy.toString().equalsIgnoreCase("VISIBLE")) {
            element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittimeinsec()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy.toString().equalsIgnoreCase("PRESENCE")) {
            element=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittimeinsec()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        return element;
    }
    public static void waitTillPageLoad(){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaittimeinsec()))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

}
