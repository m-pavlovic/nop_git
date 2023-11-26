package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import com.marijapavlovic.zadatak_1_2.data_save_load_bmi.ReadWriteTxt;
import java.util.Arrays;

public class TablePanel extends JPanel implements Observer {

    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel() {
        initComps();
        layoutComps();
    }

    private void initComps() {
        String columns[] = {"Height", "Weight", "Category", "BMI"};
        String data[][] = {{"", "", "", ""}};
        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
    }

    private void layoutComps() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    @Override
    public void update(float height, float weight, String category, float bmi) {
        String[] rowData = {String.valueOf(height), String.valueOf(weight), category, String.valueOf(bmi)};
        if (tableModel.getRowCount() == 1 && tableModel.getValueAt(0, 0).equals("")) {
            tableModel.removeRow(0);
        }
        tableModel.addRow(rowData);
    }

    public void clearTable() {
        tableModel.setRowCount(0);
        String columns[] = {"Height", "Weight", "Category", "BMI"};
        String data[][] = {{"", "", "", ""}};
        tableModel = new DefaultTableModel(data, columns);
        table.setModel(tableModel);
    }


    public void loadTableFromFile(String filePath) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            clearTable();
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                //Person person = ReadWriteClass.parsePersonFromString(line);
//                Person person = ReadWriteTxt.parsePersonFromString(line);
//                String[] rowData = {String.valueOf(person.getPersonHeight()), String.valueOf(person.getWeight()), person.getCategory(), String.valueOf(person.getBmi())};
//                tableModel.addRow(rowData);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        if (filePath.endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                clearTable();

                String line;
                while ((line = reader.readLine()) != null) {
                    Person person = ReadWriteTxt.parsePersonFromString(line);
                    String[] rowData = {String.valueOf(person.getPersonHeight()), String.valueOf(person.getWeight()), person.getCategory(), String.valueOf(person.getBmi())};
                    tableModel.addRow(rowData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (filePath.endsWith(".bin")) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)))) {
                clearTable();

                while (true) {
                    Person person = (Person) ois.readObject();
                    String[] rowData = {String.valueOf(person.getPersonHeight()), String.valueOf(person.getWeight()), person.getCategory(), String.valueOf(person.getBmi())};
                    tableModel.addRow(rowData);
                }
            } catch (EOFException e) {
                // end of file reached
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}