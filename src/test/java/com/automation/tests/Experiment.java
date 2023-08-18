package com.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Experiment {

    @BeforeMethod
    public void setUp(Object[] data){
        System.out.println(data[0]);
    }

    @Parameters({"browser"})
    @Test
    public void test1(String browser){
        System.out.println(browser);
    }
}
