package com.springboot.demo.util.Base64;

import java.io.*;
import java.net.URLDecoder;

/**
 * 此处的文件下载和上传指的是文件内容改成base64格式进行传输
 */
public class Base64Test {
    public static boolean base64Tsst(String imgFile) {
        File imgStr = new File("g:/test.txt");
        if (imgStr.exists()) { //判断文件夹存
            InputStream is = null;
            try {
                is = new FileInputStream(imgStr);
                int temp;
                String imgStrs = "";
                while ((temp = is.read()) != -1) {
                    imgStrs = imgStrs + (char) temp;
                }
                //imgFile附件下载路径
                File img = new File(imgFile);
                if (!img.exists()) {
                    img.createNewFile();
                }
                //转码,将/转化为base64
                //Base64Util.generateImage(URLDecoder.decode(imgStrs,"UTF-8"),imgFile);
                //不进行转码
                Base64Util.generateImage(imgStrs, imgFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != is) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
