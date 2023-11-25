package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import java.awt.*;

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

    @Override
    public void update(float height, float weight, String category, float bmi) {
        counter++;
        progressBar.setValue(counter);
        progressBar.setMaximum(5);
        if (counter == 5) {
            counter = 0;
        }

    }

    public void clearProgress() {
        progressBar.setValue(0);
    }
}
