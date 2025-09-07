package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {

    }

    public static String readkey(String key) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
            p = new Properties();
            p.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p.getProperty(key);
    }
}
