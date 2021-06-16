package com.sandwich.controller;

import com.sandwich.model.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpiceController {
    @Autowired
    private ISpiceService spiceService;

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/save-spices")
    public String saveSpices(@RequestParam String[] spices, Model model) {
        List<String> spicesList;
        spicesList = spiceService.saveSpices(spices);
        model.addAttribute("spicesList",spicesList);
        return "spices-list";
    }
}
