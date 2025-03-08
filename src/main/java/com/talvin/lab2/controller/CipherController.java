package com.talvin.lab2.controller;

import com.talvin.lab2.cipher.caesar.CaesarCipher;
import com.talvin.lab2.cipher.vigenere.VigenereCipher;
import com.talvin.lab2.cipher.xor.XorCipher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cipher")
class CipherWebController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/caesar")
    public String caesar(@RequestParam String text, @RequestParam int shift, Model model) {
        CaesarCipher cipher = new CaesarCipher(shift);
        model.addAttribute("originalText", text);
        model.addAttribute("encryptedText", cipher.encrypt(text, ""));
        model.addAttribute("decryptedText", cipher.decrypt(cipher.encrypt(text, ""), ""));
        return "index";
    }

    @PostMapping("/vigenere")
    public String vigenere(@RequestParam String text, @RequestParam String key, Model model) {
        VigenereCipher cipher = new VigenereCipher();
        model.addAttribute("originalText", text);
        model.addAttribute("encryptedText", cipher.encrypt(text, key));
        model.addAttribute("decryptedText", cipher.decrypt(cipher.encrypt(text, key), key));
        return "index";
    }

    @PostMapping("/xor")
    public String xor(@RequestParam String text, @RequestParam String key, Model model) {
        XorCipher cipher = new XorCipher();
        model.addAttribute("originalText", text);
        model.addAttribute("encryptedText", cipher.encrypt(text, key));
        model.addAttribute("decryptedText", cipher.decrypt(cipher.encrypt(text, key), key));
        return "index";
    }
}