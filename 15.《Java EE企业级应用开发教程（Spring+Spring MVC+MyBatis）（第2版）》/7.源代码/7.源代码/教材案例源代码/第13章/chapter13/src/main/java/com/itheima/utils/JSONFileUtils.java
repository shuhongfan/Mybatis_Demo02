package com.itheima.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JSONFileUtils {
    public static String readFile(String filepath) throws Exception {
        FileInputStream fis = new FileInputStream(filepath);
        return IOUtils.toString(fis);
    }

    public static void writeFile(String data, String filepath)
            throws Exception {
        FileOutputStream fos = new FileOutputStream(filepath);
        IOUtils.write(data, fos);
    }
}

