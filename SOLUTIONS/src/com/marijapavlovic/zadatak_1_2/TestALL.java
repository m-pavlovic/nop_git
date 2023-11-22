package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;

public class TestALL {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
