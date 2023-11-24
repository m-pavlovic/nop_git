package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;

public class App {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });

    }
}
