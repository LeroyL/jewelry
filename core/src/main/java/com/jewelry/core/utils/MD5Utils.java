package com.jewelry.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lier on 2017/10/11.
 */
public class MD5Utils {

    private static MessageDigest digest = null;

    private MD5Utils() {
    }

    public static final synchronized String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        digest.update(data.getBytes());
        return encodeHex(digest.digest());
    }

    private static final String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; ++i) {
            if ((bytes[i] & 255) < 16) {
                buf.append("0");
            }
            buf.append(Long.toString((long) (bytes[i] & 255), 16));
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String message = "123456admin";
        System.out.println(MD5Utils.hash(message));
    }
}
