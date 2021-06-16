package com.calculator.model.service.impl;

import com.calculator.model.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double operate(double number1, double number2, String operation) {
        double result = 0;
        switch (operation) {
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1 * number2;
                break;
            case "Division":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
