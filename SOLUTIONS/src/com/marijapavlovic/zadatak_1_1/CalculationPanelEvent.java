package com.marijapavlovic.zadatak_1_1;

import java.awt.event.ActionListener;
import java.util.EventObject;

public class CalculationPanelEvent extends EventObject {

    private double firstNumber;
    private double secondNumber;
    private String operation;


    public CalculationPanelEvent(Object source) {
        super(source);
    }

    public CalculationPanelEvent(ActionListener source, double firstNumber, double secondNumber, String operation) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
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
}
