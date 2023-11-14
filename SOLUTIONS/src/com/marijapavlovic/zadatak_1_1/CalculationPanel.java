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
        firstNumberTextField.setBounds(120, 100, 100, 25);
        secondNumberLabel.setBounds(20, 140, 100, 25);
        secondNumberTextField.setBounds(120, 140, 100, 25);
        scrollPane.setBounds(300, 80, 200, 80);
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
                    fillCalcData();

                    if (calculationPanelListener != null) {
                        calculationPanelListener.calculationEventOccurred(new CalculationPanelEvent(this, firstNumber, secondNumber, operation));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void fillCalcData() {
        ViewPanel.calcData.setFirstNumber(Double.parseDouble(firstNumberTextField.getText()));
        ViewPanel.calcData.setSecondNumber(Double.parseDouble(secondNumberTextField.getText()));
        ViewPanel.calcData.setOperation(list.getSelectedValue());
        ViewPanel.calcData.setResult(resultTextField.getText());
    }
}