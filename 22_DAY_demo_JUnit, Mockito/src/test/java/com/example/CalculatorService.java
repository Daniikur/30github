package com.example;

public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int addNumbers(int a, int b) {
        return calculator.add(a, b);
    }
}
