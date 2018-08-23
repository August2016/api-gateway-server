package com.example.gateway.api.encrypts;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class BlowFish {

    private static final String BLOWFISH = "Blowfish";

    public static String encryp(String key, String toBeEncrypted) {
        final byte[] keyBytes = key.getBytes();
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, BLOWFISH);
        Cipher cipher;
        byte[] encoding;
        try {
            cipher = Cipher.getInstance(BLOWFISH);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            encoding = cipher.doFinal(toBeEncrypted.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("加密异常", e);
        }

        final String encryptedData = DatatypeConverter.printBase64Binary(encoding);

        return encryptedData;

    }

    public static String decryp(String key, String toBeDecrypted) {
        final byte[] keyBytes = key.getBytes();
        Cipher cipher;
        byte[] message;
        SecretKeySpec keySpec;

        try {
            cipher = Cipher.getInstance(BLOWFISH);
            byte[] cipherText = DatatypeConverter.parseBase64Binary(toBeDecrypted);
            keySpec = new SecretKeySpec(keyBytes, BLOWFISH);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            message = cipher.doFinal(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("解密异常", e);
        }

        final String decrypted = new String(message);
        return decrypted;
    }
}
