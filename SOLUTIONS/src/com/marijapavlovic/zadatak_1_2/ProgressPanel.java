package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import java.awt.*;

public class ProgressPanel extends JPanel {


    private JPanel insidePanel;
    private JProgressBar progressBar;

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
}
