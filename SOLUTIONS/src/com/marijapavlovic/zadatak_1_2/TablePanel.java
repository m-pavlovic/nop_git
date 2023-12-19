package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import com.marijapavlovic.zadatak_1_2.data_save_load_bmi.ReadWriteTxt;
import java.util.Arrays;
import java.util.List;

public class TablePanel extends JPanel implements Observer {

    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel() {
        initComps();
        layoutComps();
    }

    private void initComps() {
        String columns[] = {"Height", "Weight", "Category", "BMI"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
    }

    private void layoutComps() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    public void clearTable() {
        String columns[] = {"Height", "Weight", "Category", "BMI"};
        tableModel = new DefaultTableModel(columns, 0);
        table.setModel(tableModel);
    }

    @Override
    public <E> void update(List<E> persons) {
        clearTable();
        for (E person : persons) {
            String[] rowData = {String.valueOf(((Person) person).getPersonHeight()), String.valueOf(((Person) person).getWeight()), ((Person) person).getCategory(), String.valueOf(((Person) person).getBmi())};
            tableModel.addRow(rowData);
        }

    }
}