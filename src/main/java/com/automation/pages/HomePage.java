package com.automation.pages;

import com.automation.enums.WaitStrategy;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private By dashBoard= By.tagName("h6");

    public String getTitle(WaitStrategy waitStrategy,String text){
        return getPageTitle(waitStrategy,dashBoard);
    }
}
