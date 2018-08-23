package com.example.gateway.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 获取随机字符串
 */
public class RandomStringUtils {

    private static String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIFGKLMNO·～`PQRSTUVWXYZ!@#$%^&*()-+_+{}|\":?><;";

    /**
     * 获取随机数
     *
     * @param size
     * @return
     */
    public static String nextString(Integer size) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = ThreadLocalRandom.current().nextInt(length);
            stringBuilder.append(str.charAt(index));
        }
        return stringBuilder.toString();
    }
}
