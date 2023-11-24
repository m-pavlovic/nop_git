package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {

    private JTable table;
    private JScrollPane scrollPane;

    public TablePanel(){
        initComps();
        layoutComps();
    }

    private void initComps() {
        table = new JTable();
        scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void layoutComps() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
    }
}
