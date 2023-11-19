package com.marijapavlovic.zadatak_1_1;

import com.marijapavlovic.zadatak_1_1.data_save_load.LoadFromBinFile;
import com.marijapavlovic.zadatak_1_1.data_save_load.LoadFromTxtFile;
import com.marijapavlovic.zadatak_1_1.data_save_load.SaveToBinFile;
import com.marijapavlovic.zadatak_1_1.data_save_load.SaveToTxtFile;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private ViewPanel viewPanel;
    private CalculationPanel calculationPanel;
    private MenuBarPanel menuBarPanel;
    private CalculationPanelListener calculationPanelListener;
    private JFileChooser fileChooser = new JFileChooser();
    private ArrayList<CalcData> calcData = new ArrayList<>();
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
        calcData = new ArrayList<>();
        fileChooser.setCurrentDirectory(new File("com/marijapavlovic/zadatak_1_1/data_save_load"));
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
                "TXT files", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "BIN files", "bin");
        fileChooser.setFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        alignSaveWithExtensions();
    }

    private void layoutComps() {
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);
        add(calculationPanel, BorderLayout.SOUTH);
        add(menuBarPanel, BorderLayout.NORTH);
    }

    private void alignSaveWithExtensions(){
        fileChooser.addActionListener(ae -> {
            if (ae.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)){
                String path = fileChooser.getSelectedFile().getPath();
                if (fileChooser.getFileFilter().getDescription().equals("TXT files")){
                    if (!path.endsWith(".txt")){
                        path += ".txt";
                    }
                } else if (fileChooser.getFileFilter().getDescription().equals("BIN files")){
                    if (!path.endsWith(".bin")){
                        path += ".bin";
                    }
                }
                fileChooser.setSelectedFile(new File(path));
            }
        });

    }

    private void activateApp() {
        calculationPanelListener = new CalculationPanelListener() {
            @Override
            public void calculationEventOccurred(CalculationPanelEvent e) {
                CalcData calcData = e.getData();
                viewPanel.appendToTextArea(calcData);
            }
        };
        calculationPanel.setCalculationPanelListener(calculationPanelListener);

        menuBarPanel.setMenuBarListener(new MenuBarListener() {
            @Override
            public void saveEventOccurred(MenuBarEvent menuBarEvent) {
                int value = fileChooser.showSaveDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    if (path.endsWith(".txt")) {
                        new SaveToTxtFile();
                    } else if (path.endsWith(".bin")) {
                        new SaveToBinFile();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please choose a file extension!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }


            }

            @Override
            public void exitEventOccurred(MenuBarEvent menuBarEvent) {
                System.exit(0);

            }

            @Override
            public void loadEventOccurred(MenuBarEvent menuBarEvent) {
                int value = fileChooser.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    if (path.endsWith(".txt")) {
                        new LoadFromTxtFile();
                    } else if (path.endsWith(".bin")) {
                        new LoadFromBinFile();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please choose a file extension!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        menuBarPanel.activateComps();
    }
}