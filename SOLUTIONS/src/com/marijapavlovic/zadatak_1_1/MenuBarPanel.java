package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MenuBarPanel extends JMenuBar {

    private MenuBarListener menuBarListener;
    private JMenu file;
    private JMenuItem load;
    private JMenuItem save;
    private JMenuItem exit;

    public MenuBarPanel() {
        initPanelComps();
        layoutComps();
        activateComps();
    }

    private void initPanelComps() {
        file = new JMenu("File");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
    }

    private void layoutComps() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(file);
        file.add(load);
        file.add(save);
        file.add(exit);
    }

    public void setMenuBarListener(MenuBarListener menuBarListener) {
        this.menuBarListener = menuBarListener;
    }

    public void activateComps() {
        if (menuBarListener != null) {
            load.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuBarListener.loadEventOccurred(new MenuBarEvent(this));
                }
            });
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuBarListener.saveEventOccurred(new MenuBarEvent(this));
                }
            });
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuBarListener.exitEventOccurred(new MenuBarEvent(this));
                }
            });
        }
    }

}