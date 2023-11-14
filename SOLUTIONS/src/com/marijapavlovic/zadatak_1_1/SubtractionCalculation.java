package com.marijapavlovic.zadatak_1_1;

public class SubtractionCalculation implements CalculationStrategy {

    double result;
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        result = firstNumber - secondNumber;
        return result;

    }

    @Override
    public void appendToResultField() {
        CalculationPanel.resultTextField.setText(String.valueOf(result));

    }

    @Override
    public void fillCalcData() {
        CalcData calcData = new CalcData(CalculationPanel.getFirstNumber(), CalculationPanel.getSecondNumber(), "Subtraction", String.valueOf(result));
        ViewPanel.appendToTextArea(calcData);
    }
}