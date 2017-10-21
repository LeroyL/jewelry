package com.jewelry.core.utils;

import org.apache.commons.text.RandomStringGenerator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtil {

    private static RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final String saveFile(String dirPrefix, InputStream inputStream){
        String dir = getFileDir(dirPrefix);
        File fileDir = new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        String fileName = generator.generate(6) + System.currentTimeMillis();
        File file = new File(dir + fileName);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1){
                out.write(buff, 0, len);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileName = null;
        } catch (IOException e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }

    public static String getFileDir(String dirPrefix){
        String date = dateFormat.format(new Date());
        String[] strs = date.split("-");
        String fileDir = dirPrefix + File.separator + strs[0] + File.separator + strs[1] + File.separator + strs[2] + File.separator;
        return fileDir;
    }

    public static String getFileName(String sourceName){
        return System.currentTimeMillis() + "_" + sourceName.replaceAll(" ", "_");
    }
}
