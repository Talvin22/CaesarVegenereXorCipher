package com.talvin.lab2.cipher;

public interface Cipher {
    String encrypt(String text, String key);
    String decrypt(String text, String key);
}

