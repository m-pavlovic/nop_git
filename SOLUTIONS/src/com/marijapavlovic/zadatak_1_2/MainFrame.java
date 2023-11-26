package com.marijapavlovic.zadatak_1_2;

import com.marijapavlovic.zadatak_1_2.data_save_load_bmi.ReadWriteBin;
import com.marijapavlovic.zadatak_1_2.data_save_load_bmi.ReadWriteStrategy;
import com.marijapavlovic.zadatak_1_2.data_save_load_bmi.ReadWriteTxt;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements Observable {

    private ViewPanel viewPanel;
    private FormPanel formPanel;

    private ToolBar toolBar;
    private TablePanel tablePanel;
    private ProgressPanel progressPanel;


    private final JFileChooser fileChooser = new JFileChooser();

    private static final String DIR = "DATA";

    private ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Observer> observers;



    public MainFrame(){
        super("BMI APP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        initComps();
        layoutComps();
        activateFrame();

    }

    private void initComps(){
        observers = new ArrayList<>();
        viewPanel = new ViewPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        progressPanel = new ProgressPanel();
        toolBar = new ToolBar();
        persons = new ArrayList<>();
        fileChooser.setCurrentDirectory(new File(DIR));
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
                "TXT files", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "BIN files", "bin");
        fileChooser.setFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        alignSaveWithExtensions();
    }

    private void layoutComps(){
        setLayout(new BorderLayout());
        viewPanel.setPreferredSize(new Dimension(300, 300));
        add(viewPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(progressPanel, BorderLayout.EAST);
        add(formPanel, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);
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


    private boolean dirExists(String path){
        return new File(path).exists();
    }



    private void activateFrame(){
        addObserver(viewPanel);
        addObserver(tablePanel);
        addObserver(progressPanel);

        formPanel.setFormPanelListener(new FormPanelListener() {
            @Override
            public void formEventOccurred(FormEvent fe) {
                if (persons.size() < 5) {
                    persons.add(fe.getPerson());
                    notifyObservers();
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Maximum number of persons is 5!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void clearEventOccurred() {
                viewPanel.clearText();
                tablePanel.clearTable();
                progressPanel.clearProgress();
            }

            @Override
            public void saveEventOccurred() {
                int value = fileChooser.showSaveDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
//                    if (ReadWriteClass.fileExtension(path).equals("bin")) {
//                        // append Person object to the file
//                        ReadWriteClass.writeToBinFile(path, persons);
//                    } else {
//                        // append toString representation of the Person object to the file
//                        ReadWriteClass.writeToTextFile(path, persons);
//                    }
                    if (ReadWriteStrategy.fileExtension(path).equals("bin")) {
                        // append Person object to the file
                        new ReadWriteBin().saveToFile(path, persons);
                    } else {
                        // append toString representation of the Person object to the file
                        new ReadWriteTxt().saveToFile(path, persons);
                    }
                }
            }


            @Override
            public void loadEventOccurred() {

                viewPanel.clearText();
                tablePanel.clearTable();
                progressPanel.clearProgress();
                persons.clear();
                StringBuffer sb = null;
                int value = fileChooser.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION){
                    String path = fileChooser.getSelectedFile().getPath();
                    // read from file and then append to the viewPanel
//                    if (ReadWriteClass.fileExtension(path).equals("bin"))
//                        sb = ReadWriteClass.readFromBinFile(path, persons);
//                    else {
//                        sb = ReadWriteClass.readFromTextFile(path, persons);
//                    }
                    if (ReadWriteStrategy.fileExtension(path).equals("bin"))
                        sb = new ReadWriteBin().loadFromFile(path, persons);
                    else {
                        sb = new ReadWriteTxt().loadFromFile(path, persons);
                    }
                    viewPanel.appendText(sb.toString());
                    tablePanel.loadTableFromFile(path);
                    progressPanel.loadProgressFromFile(path);
                    System.out.println(persons);
                }

            }

            @Override
            public void exitEventOccurred() {
                int value = JOptionPane.showConfirmDialog(null, "Hvala na koristenju aplikacije!", "Izlaz", JOptionPane.CANCEL_OPTION);
                if (value == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer " + observer.getClass().getSimpleName() + " added!");

    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            System.out.println("Observer " + observer.getClass().getSimpleName() + " removed!");
        }
        else
            System.out.println("Observer not found!");

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers){
            float height = formPanel.getPersonHeight();
            float weight = formPanel.getWeight();
            String category = formPanel.getCategory();
            float bmi = formPanel.getBmi();
            observer.update(height, weight, category, bmi);
        }

    }
}
