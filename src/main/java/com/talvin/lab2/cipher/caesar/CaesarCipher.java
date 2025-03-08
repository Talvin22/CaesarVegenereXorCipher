package com.talvin.lab2.cipher.caesar;

import com.talvin.lab2.cipher.Cipher;

public class CaesarCipher implements Cipher {
    private final int shift;
    private static final String UKRAINIAN_ALPHABET = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String LOWERCASE_ALPHABET = "абвгґдеєжзииіїйклмнопрстуфхцчшщьюя";

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String text, String key) {
        return shiftText(text, shift);
    }

    @Override
    public String decrypt(String text, String key) {
        return shiftText(text, -shift);
    }

    private String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (UKRAINIAN_ALPHABET.indexOf(c) != -1 || LOWERCASE_ALPHABET.indexOf(c) != -1) {
                String alphabet = Character.isUpperCase(c) ? UKRAINIAN_ALPHABET : LOWERCASE_ALPHABET;
                int index = (alphabet.indexOf(c) + shift + alphabet.length()) % alphabet.length();
                result.append(alphabet.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}