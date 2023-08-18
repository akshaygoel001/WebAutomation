package com.automation.utils;


import com.automation.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadConfigPropertiesFile {

    private ReadConfigPropertiesFile() {
    }
    private static final Properties prop = new Properties();
    private static final Map<Object,Object> CONFIGMAP=new HashMap<>();

    static {
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            prop.load(fs);
            for (Map.Entry<Object,Object> entry : prop.entrySet()) {
                CONFIGMAP.put(entry.getKey().toString().toUpperCase(),entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String key) throws IOException {
        if(Objects.isNull(key)){
            throw new FileNotFoundException("Property with name "+key+"  not found in config properties file");
        } else if (Objects.isNull(CONFIGMAP.get(key))) {
            throw new IOException("Property value not found in config properties file");
        }
        return String.valueOf(CONFIGMAP.get(key));
    }
}
