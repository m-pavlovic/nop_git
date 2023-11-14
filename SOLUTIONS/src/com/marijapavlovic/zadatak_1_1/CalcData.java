package com.marijapavlovic.zadatak_1_1;

public class CalcData {

    private double firstNumber;
    private double secondNumber;
    private String operation;
    private String result;

    public CalcData(double firstNumber, double secondNumber, String operation, String result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.result = result;
    }


    @Override
    public String toString() {
        return "CalcData{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                '}' + "\n" + "======================================================================================";
    }
}
