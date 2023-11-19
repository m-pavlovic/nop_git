package com.marijapavlovic.zadatak_1_1;

import java.awt.event.ActionListener;
import java.util.EventObject;

public class CalculationPanelEvent extends EventObject {

    private double firstNumber;
    private double secondNumber;
    private String operation;
    private CalcData calcData;


    public CalculationPanelEvent(Object source) {
        super(source);
    }


    public CalculationPanelEvent(Object source, CalcData calcData) {
        super(source);
        this.calcData = calcData;
    }

    public CalculationPanelEvent(Object source, double firstNumber, double secondNumber, String operation, CalcData calcData) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.calcData = calcData;
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

    public CalcData getData() {
        return calcData;
    }
}
