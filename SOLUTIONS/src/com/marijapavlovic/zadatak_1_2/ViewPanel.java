package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewPanel extends JPanel implements Observer {

    private JTextArea txtArea;
    private JScrollPane scrollPane;

    public ViewPanel(){
        initComps();
        layoutComps();
    }

    private void initComps(){
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void layoutComps(){
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendText(String text){
        txtArea.append(text);
    }

    public void clearText(){
        txtArea.setText(null);
    }

    @Override
    public <E> void update(List<E> persons) {
        clearText();
        for (E person : persons) {
            appendText(person.toString() + "\n");
        }

    }
}
