package com.example.testexercise.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.io.OutputStream;

@UtilityClass
public class StreamUtils {

    public static final int CHUNK_SIZE = 8192;

    @SneakyThrows
    public void writeToOutputStream(InputStream in, OutputStream out) {
        int read;
        byte[] bytes = new byte[CHUNK_SIZE];
        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
    }
}