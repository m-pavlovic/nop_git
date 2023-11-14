package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;

public class DivisionCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        result = firstNumber / secondNumber;
        ViewPanel.appendToTextArea();

        return result;

    }

    @Override
    public void appendToResultField() {
        CalculationPanel.resultTextField.setText(String.valueOf(result));

    }
}