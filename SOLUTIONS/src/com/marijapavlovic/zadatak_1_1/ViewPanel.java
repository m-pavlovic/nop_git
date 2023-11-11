package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;

public class ViewPanel extends JPanel {

    static JTextArea textArea = new JTextArea(20, 69);
    JScrollPane scrollPane = new JScrollPane(textArea);

    public ViewPanel() {
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    public static void appendToTextArea(String text) {
        textArea.append(text);
    }
}
