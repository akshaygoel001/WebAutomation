package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.enums.WaitStrategy;
import com.automation.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {

    protected void click(WaitStrategy waitStrategy, By by){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
    }
    protected void sendKeys(WaitStrategy waitStrategy, By by,String value){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
    }
    protected void getText(WaitStrategy waitStrategy, By by){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).getText();
    }
    protected String getPageTitle(WaitStrategy waitStrategy,By by){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        return DriverManager.getDriver().getTitle();
    }
    protected String getPageTitle(){
        ExplicitWaitFactory.waitTillPageLoad();
        return DriverManager.getDriver().getTitle();
    }
    public void scrollToElement(By by){
        WebElement element=DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void moveToElement(By by){
        WebElement element=DriverManager.getDriver().findElement(by);
        new Actions(DriverManager.getDriver()).moveToElement(element).build().perform();
    }
}
