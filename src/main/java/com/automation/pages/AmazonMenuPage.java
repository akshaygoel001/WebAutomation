package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class AmazonMenuPage extends BasePage{

    private List<WebElement> menuList= DriverManager.getDriver().findElements(By.cssSelector("ul.hmenu.hmenu-visible.hmenu-translateX"));


    public AmazonMenuPage clickMenuItem(WaitStrategy waitStrategy,String menuItemText) throws IOException {
        By menuItem=By.linkText(menuItemText);
        click(waitStrategy,menuItem);
        ExtentLogger.pass("Menu "+menuItemText+" clicked successfully");
        return this;
    }
    public  AmazonMenuPage scrollTo(String text) throws IOException {
        By textLink= By.linkText(text);
        scrollToElement(textLink);
        ExtentLogger.pass("Scrolled to "+text+" successfully");
        return this;
    }
    public AmazonMenuPage clickSubMenu(WaitStrategy waitStrategy,String subMenuText) throws IOException {
        By subMenuLink= By.linkText(subMenuText);
        click(waitStrategy,subMenuLink);
        ExtentLogger.pass("Sub Menu "+subMenuText+" clicked successfully");
        return this;
    }

    public String getTitle() throws IOException {
        String title= getPageTitle();
        ExtentLogger.pass("Page Title is:"+title);
        return title;
    }
}
