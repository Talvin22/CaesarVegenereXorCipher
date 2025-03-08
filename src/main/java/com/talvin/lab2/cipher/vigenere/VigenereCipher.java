package com.talvin.lab2.cipher.vigenere;

import com.talvin.lab2.cipher.Cipher;

public class VigenereCipher implements Cipher {
    private static final String UKRAINIAN_ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String LOWERCASE_ALPHABET = "абвгґдеєжзииіїйклмнопрстуфхцчшщьюя";

    @Override
    public String encrypt(String text, String key) {
        return process(text, key, true);
    }

    @Override
    public String decrypt(String text, String key) {
        return process(text, key, false);
    }

    private String process(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            String alphabet = Character.isUpperCase(c) ? UKRAINIAN_ALPHABET : LOWERCASE_ALPHABET;
            int alphabetIndex = alphabet.indexOf(c);
            if (alphabetIndex != -1) {
                int shift = alphabet.indexOf(key.charAt(keyIndex % key.length()));
                if (!encrypt) shift = -shift;
                int newIndex = (alphabetIndex + shift + alphabet.length()) % alphabet.length();
                result.append(alphabet.charAt(newIndex));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}