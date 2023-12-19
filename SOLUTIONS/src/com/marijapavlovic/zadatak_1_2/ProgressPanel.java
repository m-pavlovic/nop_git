package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgressPanel extends JPanel implements Observer {


    private JPanel insidePanel;
    private JProgressBar progressBar;
    private int counter = 0;

    public ProgressPanel(){
        initComps();
        layoutComps();
    }

    private void initComps() {
        insidePanel = new JPanel();
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
    }

    private void layoutComps() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        insidePanel.setBorder(BorderFactory.createTitledBorder("Progress"));
        add(insidePanel);
        insidePanel.setLayout(new GridBagLayout());
        insidePanel.add(progressBar);
    }



    public void clearProgress() {
        progressBar.setValue(0);
    }


    @Override
    public <E> void update(List<E> persons) {
        progressBar.setMaximum(5);
        progressBar.setValue(persons.size());

    }
}
