package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationPanel extends JPanel {

    private JPanel insidePanel = new JPanel();
    private JLabel firstNumberLabel = new JLabel("First number:");
    private JLabel secondNumberLabel = new JLabel("Second number:");
    private static String[] operations = {"Addition", "Subtraction", "Division", "Multiplication", "Power To"};
    private static JList<String> list = new JList<>(operations);
    private JScrollPane scrollPane = new JScrollPane();
    private static JTextField firstNumberTextField = new JTextField();
    private static JTextField secondNumberTextField = new JTextField();
    private JButton calculateButton = new JButton("Calculate");
    public static JTextField resultTextField = new JTextField();
    private CalculationPanelListener calculationPanelListener;

    public CalculationPanel() {
        insidePanel.setLayout(null);
        insidePanel.setBorder(BorderFactory.createTitledBorder("Calculation"));
        insidePanel.setPreferredSize(new Dimension(760, 290));

        firstNumberLabel.setBounds(20, 100, 100, 25);
        firstNumberTextField.setBounds(160, 100, 100, 25);
        secondNumberLabel.setBounds(20, 140, 120, 25);
        secondNumberTextField.setBounds(160, 140, 100, 25);
        scrollPane.setBounds(300, 100, 200, 60);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(list);
        calculateButton.setBounds(600, 220, 100, 25);
        resultTextField.setBounds(570, 120, 150, 30);
        resultTextField.setEditable(false);

        insidePanel.add(firstNumberLabel);
        insidePanel.add(firstNumberTextField);
        insidePanel.add(secondNumberLabel);
        insidePanel.add(secondNumberTextField);
        insidePanel.add(scrollPane);
        insidePanel.add(calculateButton);
        insidePanel.add(resultTextField);

        add(insidePanel);
        activateComps();
    }

    public void setCalculationPanelListener(CalculationPanelListener calculationPanelListener) {
        this.calculationPanelListener = calculationPanelListener;
    }

    private void activateComps() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double firstNumber = Double.parseDouble(firstNumberTextField.getText());
                    double secondNumber = Double.parseDouble(secondNumberTextField.getText());
                    String operation = list.getSelectedValue();
                    if (!isCalculationChosen()) {
                        JOptionPane.showMessageDialog(null, "Please choose an operation!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    CalculationStrategy calculation = getStrategy(operation);
                    if (operation.equals("Division") && secondNumber == 0) {
                        JOptionPane.showMessageDialog(null, "You can't divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double result = calculation.calculate(firstNumber, secondNumber);

                    CalcData calcData = new CalcData(firstNumber, secondNumber, operation, result);
                    CalculationPanelEvent calculationPanelEvent = new CalculationPanelEvent(this, firstNumber, secondNumber, operation, calcData);

                    if(calculationPanelListener != null) {
                        calculationPanelListener.calculationEventOccurred(calculationPanelEvent);
                        resultTextField.setText(String.valueOf(result));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean isCalculationChosen() {
        return list.getSelectedValue() != null;
    }

    private CalculationStrategy getStrategy(String operation) {
        CalculationStrategy calculation = null;

        switch (operation) {
            case "Addition":
                calculation = new AdditionCalculation();
                break;
            case "Subtraction":
                calculation = new SubtractionCalculation();
                break;
            case "Division":
                calculation = new DivisionCalculation();
                break;
            case "Multiplication":
                calculation = new MultiplicationCalculation();
                break;
            case "Power To":
                calculation = new PowerToCalculation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please choose an operation!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        return calculation;
    }

}