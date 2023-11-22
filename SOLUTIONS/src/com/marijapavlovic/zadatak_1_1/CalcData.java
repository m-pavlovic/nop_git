package com.marijapavlovic.zadatak_1_1;

import java.io.Serializable;
import java.util.ArrayList;

public class CalcData implements Serializable {

    private double firstNumber;
    private double secondNumber;
    private String operation;
    private double result;

    public CalcData(double firstNumber, double secondNumber, String operation, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.result = result;
    }


    @Override
    public String toString() {
        return "CalcData{" +
                "firstNumber=" + firstNumber +
                ",secondNumber=" + secondNumber +
                ",operation=" + operation +
                ",result=" + result +
                '}' + "\n" + "======================================================================================";
    }
}
