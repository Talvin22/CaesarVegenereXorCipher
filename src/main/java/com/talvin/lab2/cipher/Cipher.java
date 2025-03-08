package com.talvin.lab2.caesar;

interface Cipher {
    String encrypt(String text, String key);
    String decrypt(String text, String key);
}

