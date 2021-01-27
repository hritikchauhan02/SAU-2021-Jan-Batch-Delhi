package com.calculator;

public class CalculatorImpl implements Calculator {

    public double add(double num1, double num2) {
        return num1+num2;
    }

    public double subtract(double num1, double num2) {
        return num1-num2;
    }

    public double multiply(double num1, double num2) {
        return num1*num2;
    }

    public double divide(double num1, double num2) throws Exception {
        if (num2==0)
            throw new ArithmeticException("Divide by zero Exception");
        return num1/num2;
    }
}
