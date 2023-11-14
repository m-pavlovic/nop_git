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

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalcData{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operation='" + operation + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
