package com.example.jmh;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String digits = "0123456789";

    public static Integer getInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    public static String getString(int count) {
        StringBuffer result = new StringBuffer(count);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < count; i++) {
            result.append(alpha.charAt(random.nextInt(alpha.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getString(100));
    }

}
