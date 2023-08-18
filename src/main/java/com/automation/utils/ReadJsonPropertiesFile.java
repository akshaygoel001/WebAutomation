package com.automation.utils;


import com.automation.constants.FrameworkConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReadJsonPropertiesFile {

    private ReadJsonPropertiesFile() {
    }
    private static Map<Object,Object> dataMap = null;
    private static final Map<Object,Object> CONFIGMAP=new HashMap<>();

    static {
        try {
            dataMap =new ObjectMapper()
                    .readValue(new File(FrameworkConstants.getJsonconfigfilepath()),
                            new TypeReference<HashMap<Object, Object>>() {
                            });
            for (Map.Entry<Object,Object> entry : dataMap.entrySet()) {
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
