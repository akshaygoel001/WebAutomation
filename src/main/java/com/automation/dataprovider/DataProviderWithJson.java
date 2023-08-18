package com.automation.dataprovider;

import com.automation.constants.FrameworkConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderWithJson {

    @Test(dataProvider = "jsonData")
    public void validLogin(Map<Object,Object> data){
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            Object k = entry.getKey();
            Object v = entry.getValue();
            System.out.println(k + " , " + v);
        }
    }

    @DataProvider(name = "jsonData")
    public Object[] getData() throws IOException {
        HashMap<Object,Object> dataMap=new ObjectMapper()
                .readValue(new File(FrameworkConstants.getJsonconfigfilepath()),
                        new TypeReference<HashMap<Object, Object>>() {
                        });
        return new Object[]{dataMap};
    }
}
