package com.springboot.demo.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 实时读取配置文件工具类
 *
 * @author yuansj
 */
public class PropertyUtil {

    private static String defaultFileName = "/application-dev.properties";//默认读取的配置文件名

    /**
     * 根据文件名获取Property对象
     *
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName) {
        Properties props = new Properties();
        InputStream is = null;
        try {
            is = PropertyUtil.class.getResourceAsStream(fileName);
            props.load(new InputStreamReader(is, "UTF-8"));
//            props.load(is,"UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    /**
     * 根据key获取value值
     *
     * @param key
     * @return
     */
    public static String getVal(String key) {
        if (defaultFileName == null) {
            throw new RuntimeException("请设置要加载的文件名！");
        }
        Properties props = PropertyUtil.getProperties(defaultFileName);
        String val = props.getProperty(key);
        return val;
    }

    /**
     * 根据文件名，key读取值
     *
     * @param fileName
     * @param key
     * @return
     */
    public static String getVal(String fileName, String key) {
        if (fileName == null) {
            fileName = defaultFileName;
        }
        if (defaultFileName == null) {
            throw new RuntimeException("请设置要加载的文件名！");
        }
        Properties props = PropertyUtil.getProperties(fileName);
        String val = props.getProperty(key);
        return val;
    }

    public static String getDefaultFileName() {
        return defaultFileName;
    }

    public static void setDefaultFileName(String defaultFileName) {
        PropertyUtil.defaultFileName = defaultFileName;
    }


}

