package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ViewPanel viewPanel;
    private CalculationPanel calculationPanel;
    private MenuBarPanel menuBarPanel;
    private CalculationPanelListener calculationPanelListener;
    private MenuBarListener menuBarListener;
    private AdditionCalculation additionCalculation;
    private SubtractionCalculation subtractionCalculation;
    private DivisionCalculation divisionCalculation;
    private MultiplicationCalculation multiplicationCalculation;
    private PowerToCalculation powerToCalculation;


    public MainFrame() {
        super("Calculator");
        setSize(800, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initFrameComps();
        layoutComps();
        activateApp();
        setVisible(true);

    }

    private void initFrameComps() {
        viewPanel = new ViewPanel();
        calculationPanel = new CalculationPanel();
        menuBarPanel = new MenuBarPanel();
    }

    private void layoutComps() {
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);
        add(calculationPanel, BorderLayout.SOUTH);
        add(menuBarPanel, BorderLayout.NORTH);
    }

    private void performCalculation(CalculationPanelEvent e) {
        CalculationStrategy calculation = null;

        switch (e.getOperation()) {
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

        if (calculation != null) {
            calculation.calculate(e.getFirstNumber(), e.getSecondNumber());
            calculation.appendToResultField();
        }
    }

    private void activateApp() {
        calculationPanelListener = new CalculationPanelListener() {
            @Override
            public void calculationEventOccurred(CalculationPanelEvent e) {
                performCalculation(e);
            }
        };
        calculationPanel.setCalculationPanelListener(calculationPanelListener);

        menuBarListener = new MenuBarListener() {
            @Override
            public void loadEventOccurred(MenuBarEvent menuBarEvent) {

            }

            @Override
            public void saveEventOccurred(MenuBarEvent menuBarEvent) {

            }

            @Override
            public void exitEventOccurred(MenuBarEvent menuBarEvent) {
                System.exit(0);
            }
        };
        menuBarPanel.setMenuBarListener(menuBarListener);
    }
}
