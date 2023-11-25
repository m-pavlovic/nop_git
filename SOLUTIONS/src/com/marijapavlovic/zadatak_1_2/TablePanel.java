package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel implements Observer {

    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel(){
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
}
