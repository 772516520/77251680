package com.i77251680.crypto.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Crypto {
    public static byte[] encrypt(String v) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(v.getBytes());
            return md5.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5ERROR");
        }
    }

    public static byte[] encrypt(byte[] v) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(v);
            return md5.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5ERROR");
        }
    }
}
