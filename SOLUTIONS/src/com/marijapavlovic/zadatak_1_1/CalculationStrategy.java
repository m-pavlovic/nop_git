package com.marijapavlovic.zadatak_1_1;

public interface CalculationStrategy {

    double calculate(double firstNumber, double secondNumber);

    void appendToResultField();

    void fillCalcData();
}
