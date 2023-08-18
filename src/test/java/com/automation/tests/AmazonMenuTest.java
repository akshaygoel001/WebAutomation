package com.automation.tests;

import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.pages.AmazonMenuPage;
import com.automation.pages.AmazonSignInHomePage;
import com.automation.reports.ExtentLogger;
import com.automation.utils.ReadConfigPropertiesFile;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmazonMenuTest extends Base{

    @Parameters({"browser"})
    @Test
    public void checkSubMenu(String browser) throws IOException {
        ExtentLogger.info("Test starts in browser "+browser);
        System.out.println(browser+" -> Page Title is: "+ DriverManager.getDriver().getTitle());
        String pageTitle=new AmazonSignInHomePage()
                .openProductsMenu(WaitStrategy.CLICKABLE)
                .scrollTo(ReadConfigPropertiesFile.getValue("MENUITEM"))
                .clickMenuItem(WaitStrategy.VISIBLE, ReadConfigPropertiesFile.getValue("MENUITEM"))
                .scrollTo(ReadConfigPropertiesFile.getValue("SUBMENU"))
                .clickSubMenu(WaitStrategy.VISIBLE,ReadConfigPropertiesFile.getValue("SUBMENU"))
                .getTitle();
        System.out.println(pageTitle);
    }
}
