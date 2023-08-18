package com.automation.constants;

import com.automation.utils.ReadConfigPropertiesFile;

import java.io.IOException;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static final String RESOURCEPATH=System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH =RESOURCEPATH+"/config/config.properties";
    private static final String JSONCONFIGFILEPATH =RESOURCEPATH+"/jsons/config.json";
    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/target/extent-test-output/";
    private static String extentReportFilePath="";

    private static final long IMPLICITWAITTIMEINSEC =3;
    private static final long EXPLICITWAITTIMEINSEC =3;
    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
    public static String getJsonconfigfilepath(){
        return JSONCONFIGFILEPATH;
    }
    public static long getImplicitwaittimeinsec() {
        return IMPLICITWAITTIMEINSEC;
    }
    public static long getExplicitwaittimeinsec() {
        return EXPLICITWAITTIMEINSEC;
    }
    public static String getExtentreportfilepath() throws IOException {
        if(extentReportFilePath.isEmpty()){
            if (ReadConfigPropertiesFile.getValue("OVERRIDEREPORT").equalsIgnoreCase("yes")){
                extentReportFilePath= EXTENTREPORTFOLDERPATH+"index.html";
            }
            else {
                extentReportFilePath= EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
            }
        }
        return extentReportFilePath;
    }


}
