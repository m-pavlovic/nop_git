package com.marijapavlovic.zadatak_1_1;

public class PowerToCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        result = Math.pow(firstNumber, secondNumber);
        return result;

    }

    @Override
    public void appendResult() {
        CalculationPanel.resultTextField.setText(String.valueOf(result));

    }
}