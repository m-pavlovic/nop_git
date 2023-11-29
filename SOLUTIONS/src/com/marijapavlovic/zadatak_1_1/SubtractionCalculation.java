package com.marijapavlovic.zadatak_1_1;

public class SubtractionCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        result = firstNumber - secondNumber;
        return result;

    }
}