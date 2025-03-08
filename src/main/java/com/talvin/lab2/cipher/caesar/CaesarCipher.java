package com.talvin.lab2.caesar;

class CaesarCipher implements Cipher {
    private final int shift;

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
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}