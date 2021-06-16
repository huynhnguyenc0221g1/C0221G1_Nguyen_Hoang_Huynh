package com.currency_exchange.controller;

import com.currency_exchange.service.ICurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyExchangeController {
    @Autowired
    private ICurrencyExchange currencyExchange;

    @GetMapping(value = {"/" , "/input"})
    public String input() {
        return "input";
    }

    @PostMapping(value = "/input")
    public String exchange(@RequestParam String amount, @RequestParam String rate, Model model) {
        double usd = Double.parseDouble(amount);
        double usdToVND = Double.parseDouble(rate);
        model.addAttribute("VND","$" + amount + " = VND " + currencyExchange.exchange(usd,usdToVND));
        return "input";
    }
}
