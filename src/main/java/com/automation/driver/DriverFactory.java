package com.automation.driver;

import com.automation.constants.FrameworkConstants;
import com.automation.utils.ReadConfigPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public final class DriverFactory {
    private DriverFactory(){
    }
    public static void initDriver(String browser) throws Exception {

        if(Objects.isNull(DriverManager.getDriver())){
            WebDriver driver;
            if(browser.equalsIgnoreCase("chrome")){
                driver=new ChromeDriver();
                DriverManager.setDriver(driver);
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver=new FirefoxDriver();
                DriverManager.setDriver(driver);
            } else if (browser.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
                DriverManager.setDriver(driver);
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitwaittimeinsec()));
            DriverManager.getDriver().get(ReadConfigPropertiesFile.getValue("URL"));
        }

    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
