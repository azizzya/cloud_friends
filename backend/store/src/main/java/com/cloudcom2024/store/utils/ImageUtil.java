package com.cloudcom2024.store.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtil {

    public static byte[] compressImage(byte[] data) {
        Deflater defalter = new Deflater();
        defalter.setLevel(Deflater.BEST_COMPRESSION);
        defalter.setInput(data);
        defalter.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!defalter.finished()) {
            int size = defalter.deflate(tmp);
            outputStream.write(tmp, 0, size);
        } 
        try {
            outputStream.close();
        } catch (Exception ex) {}
        return outputStream.toByteArray();
    }
    
    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ex) {}
        return outputStream.toByteArray();
    }
}
