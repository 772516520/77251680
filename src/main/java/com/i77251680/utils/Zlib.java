package com.i77251680.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Zlib {
    private static final Deflater compressor = new Deflater();
    private static Inflater inflater = new Inflater();
    private static ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static byte[] bytes = new byte[1024];

    public static byte[] zip(byte[] value) {
        out.reset();
        compressor.setInput(value);
        compressor.finish();
        while (!compressor.finished()) {
            int count = compressor.deflate(bytes);
            out.write(bytes, 0, count);
        }
        return out.toByteArray();
    }

    public static byte[] zip(String value) {
        return zip(value.getBytes());
    }

    public static byte[] unzip(byte[] encoded) {
        out.reset();
        inflater = new Inflater();
        inflater.setInput(encoded);
        while (!inflater.finished()) {
            int count = 0;
            try {
                count = inflater.inflate(bytes);
            } catch (DataFormatException e) {
                throw new RuntimeException(e);
            }
            out.write(bytes, 0, count);
        }
        return out.toByteArray();
    }
}
