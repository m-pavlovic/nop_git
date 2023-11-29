package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;

public class DivisionCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        result = firstNumber / secondNumber;
        return result;
    }
}