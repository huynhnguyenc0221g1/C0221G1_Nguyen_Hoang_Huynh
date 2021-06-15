package com.currency_exchange.service.impl;

import com.currency_exchange.service.ICurrencyExchange;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeImpl implements ICurrencyExchange {
    @Override
    public double exchange(double amount, double rate) {
        return (amount * rate);
    }
}
