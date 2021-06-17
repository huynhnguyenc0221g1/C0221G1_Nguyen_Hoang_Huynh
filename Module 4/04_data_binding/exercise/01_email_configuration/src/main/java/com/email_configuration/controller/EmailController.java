package com.email_configuration.controller;

import com.email_configuration.model.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
    @GetMapping("")
    public String display(ModelMap map) {
        map.addAttribute("email", new Email());
        return "index";
    }

    @RequestMapping(value = "/addEmail", method = RequestMethod.POST)
    public String submit(@ModelAttribute("email") Email email, ModelMap model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("size", email.getSize());
        model.addAttribute("signature", email.getSignature());
        model.addAttribute("filter", email.isFilter());
        return "/configuration";
    }
}
