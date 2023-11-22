package com.marijapavlovic.zadatak_1_1;

import javax.swing.*;
import java.util.ArrayList;

public class ViewPanel extends JPanel {

    static JTextArea textArea = new JTextArea(20, 69);
    JScrollPane scrollPane = new JScrollPane(textArea);


    public ViewPanel() {
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    public static void appendToTextArea(CalcData calcData) {
        textArea.append(calcData.toString() + "\n");
    }

    public ArrayList<CalcData> getDataFromTextArea() {
        ArrayList<CalcData> calcData = new ArrayList<>();
        String[] lines = textArea.getText().split("\n" + "======================================================================================");

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                try {
                    String dataString = line.substring(line.indexOf("{") + 1, line.indexOf("}")).trim();
                    String[] data = dataString.split(",");

                    if (data.length >= 4) {
                        double firstNum = Double.parseDouble(data[0].split("=")[1]);
                        double secondNum = Double.parseDouble(data[1].split("=")[1]);
                        String operation = data[2].split("=")[1];
                        double result = Double.parseDouble(data[3].split("=")[1]);

                        calcData.add(new CalcData(firstNum, secondNum, operation, result));
                    } else {
                        System.err.println("Malformed input line: " + line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return calcData;
    }



}