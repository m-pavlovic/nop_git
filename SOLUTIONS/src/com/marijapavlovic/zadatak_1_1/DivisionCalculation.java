package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;

public class DivisionCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            JOptionPane.showMessageDialog(null, "You can't divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new ArithmeticException("You can't divide by zero!");
        } else {
            result = firstNumber / secondNumber;
        }
        return result;

    }

    @Override
    public void appendResult() {
        CalculationPanel.resultTextField.setText(String.valueOf(result));

    }
}