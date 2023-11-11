package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarPanel extends JPanel {

    private MenuBarListener menuBarListener;
    private JMenuBar menuBar;
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
        menuBar = new JMenuBar();
        file = new JMenu("File");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
    }

    private void layoutComps() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(file);
        file.add(load);
        file.add(save);
        file.add(exit);
        add(menuBar);
    }

    public void setMenuBarListener(MenuBarListener menuBarListener) {
        this.menuBarListener = menuBarListener;
    }

    private void activateComps() {
        if (menuBarListener != null) {

            load.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Load Action Performed");
                    MenuBarEvent menuBarEvent = new MenuBarEvent(this);
                    menuBarEvent.setLoadItemClicked(true);
                    menuBarListener.loadEventOccurred(menuBarEvent);
                }
            });

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Save Action Performed");
                    MenuBarEvent menuBarEvent = new MenuBarEvent(this);
                    menuBarEvent.setSaveItemClicked(true);
                    menuBarListener.saveEventOccurred(menuBarEvent);
                }
            });

            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exit Action Performed");
                    MenuBarEvent menuBarEvent = new MenuBarEvent(this);
                    menuBarEvent.setExitItemClicked(true);
                    menuBarListener.exitEventOccurred(menuBarEvent);
                }
            });
        }
    }

}