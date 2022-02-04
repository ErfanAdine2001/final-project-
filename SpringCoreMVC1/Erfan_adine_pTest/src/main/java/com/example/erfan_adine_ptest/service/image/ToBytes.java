package com.example.erfan_adine_ptest.service.image;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;

public class ToBytes {

//    public static byte[] getBytees(@RequestParam MultipartFile file) throws IOException, FileNotFoundException {
    public static byte[] getBytees(File file) throws IOException, FileNotFoundException {
        byte[] buffer = new byte[300000];
        ByteArrayOutputStream os = new ByteArrayOutputStream(300000);
        FileInputStream fis = new FileInputStream(file);
        int read;
        while ((read = fis.read(buffer)) != -1) {
            os.write(buffer, 0, read);

        }

        fis.close();
        os.close();
        return os.toByteArray();

    }
}
