package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;

public class CalculationPanel extends JPanel {

    JPanel insidePanel = new JPanel();
    JLabel firstNumberLabel = new JLabel("First number:");
    JLabel secondNumberLabel = new JLabel("Second number:");
    JComboBox<String> operationComboBox = new JComboBox<>(new String[]{"Addition", "Subtraction", "Division", "Multiplication", "Power To"});
    JTextField firstNumberTextField = new JTextField();
    JTextField secondNumberTextField = new JTextField();
    JButton calculateButton = new JButton("Calculate");
    JTextField resultTextField = new JTextField();

    public CalculationPanel() {
        insidePanel.setLayout(null);
        insidePanel.setBorder(BorderFactory.createTitledBorder("Calculation"));
        insidePanel.setPreferredSize(new Dimension(760, 290));
        firstNumberLabel.setBounds(20, 100, 100, 25);
        firstNumberTextField.setBounds(120, 100, 100, 25);
        secondNumberLabel.setBounds(20, 140, 100, 25);
        secondNumberTextField.setBounds(120, 140, 100, 25);
        operationComboBox.setBounds(300, 110, 200, 40);
        calculateButton.setBounds(600, 220, 100, 25);
        resultTextField.setBounds(570, 120, 150, 30);
        resultTextField.setEditable(false);
        insidePanel.add(firstNumberLabel);
        insidePanel.add(firstNumberTextField);
        insidePanel.add(secondNumberLabel);
        insidePanel.add(secondNumberTextField);
        insidePanel.add(operationComboBox);
        insidePanel.add(calculateButton);
        insidePanel.add(resultTextField);
        add(insidePanel);
    }
}
