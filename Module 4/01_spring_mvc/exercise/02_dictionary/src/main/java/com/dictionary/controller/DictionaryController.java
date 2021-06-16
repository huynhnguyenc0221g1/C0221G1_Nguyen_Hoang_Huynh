package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController{
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping(value = {"/" , "/input"})
    public String input() {
        return "input";
    }

    @PostMapping(value = "/input")
    public String translate(@RequestParam String english, Model model) {
        String englishWord = english;
        model.addAttribute("vietnamese",dictionaryService.translate(englishWord));
        return "input";
    }
}