package com.example.gateway;

import com.example.gateway.api.encrypts.BlowFish;
import org.junit.Test;


public class BlowfishTest {

    private static final String KEY = "something";

    @Test
    public void contextLoads() {
        String valueToConvert = "Check is this working?";

        long start = System.currentTimeMillis();
        int i = 1;

        String encryptedValue = BlowFish.encryp(KEY, valueToConvert);
        long end = System.currentTimeMillis();
        System.out.println("共加密" + i + "次,耗时" + (end - start) + "毫秒");
        encryptedValue = BlowFish.decryp(KEY, encryptedValue);
        System.out.println(encryptedValue);
        end = System.currentTimeMillis();
        System.out.println("共加密" + i + "次,耗时" + (end - start) + "毫秒");

    }
}
