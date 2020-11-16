package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {
    public Properties getConfig(String filename) {
        Properties myProp = new Properties();
        try {
            File configExternalFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"TenPearls"+File.separator+"config"+File.separator+filename+".properties");
            if(configExternalFile.exists()) {
                myProp.load(new FileInputStream(configExternalFile));
            } else {
                System.out.println("File Not found "+ filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myProp;
    }
}
