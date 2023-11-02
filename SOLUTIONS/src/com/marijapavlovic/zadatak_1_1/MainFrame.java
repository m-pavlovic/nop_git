package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ViewPanel viewPanel;
    private CalculationPanel calculationPanel;
    private MenuBarPanel menuBarPanel;

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

    private void activateApp() {
    }
}
