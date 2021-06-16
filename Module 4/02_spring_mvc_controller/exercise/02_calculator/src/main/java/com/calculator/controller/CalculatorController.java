package com.calculator.controller;

import com.calculator.model.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("calculator")
    public String calculator(@RequestParam double number1, @RequestParam double number2, @RequestParam String operation, Model model) {
        double result = calculatorService.operate(number1,number2,operation);
        model.addAttribute("result",result);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        return "index";
    }
}
