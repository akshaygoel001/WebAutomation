package com.automation.pages;

import com.automation.enums.WaitStrategy;
import com.automation.reports.ExtentLogger;
import org.openqa.selenium.By;

import java.io.IOException;

public class AmazonSignInHomePage extends BasePage{

    private By menuLink= By.cssSelector("#nav-hamburger-menu");

    public AmazonMenuPage openProductsMenu(WaitStrategy waitStrategy) throws IOException {
        click(waitStrategy,menuLink);
        ExtentLogger.pass("Menu opened successfully");
        return new AmazonMenuPage();
    }
}
