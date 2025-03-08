package com.talvin.lab2.cipher.xor;

import com.talvin.lab2.cipher.Cipher;

import java.nio.charset.StandardCharsets;

import java.util.Base64;


public class XorCipher implements Cipher {
    @Override
    public String encrypt(String text, String key) {
        byte[] encryptedBytes = xorProcess(text.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String decrypt(String text, String key) {
        byte[] encryptedBytes = Base64.getDecoder().decode(text);
        byte[] decryptedBytes = xorProcess(encryptedBytes, key.getBytes(StandardCharsets.UTF_8));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    private byte[] xorProcess(byte[] textBytes, byte[] keyBytes) {
        byte[] result = new byte[textBytes.length];

        for (int i = 0; i < textBytes.length; i++) {
            result[i] = (byte) (textBytes[i] ^ keyBytes[i % keyBytes.length]);
        }
        return result;
    }
}

