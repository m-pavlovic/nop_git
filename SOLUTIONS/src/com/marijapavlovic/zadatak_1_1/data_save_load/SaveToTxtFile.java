package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveToTxtFile implements SaveStrategy {


    @Override
    public void saveToFile(String path, ArrayList<CalcData> calcData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for (CalcData data : calcData){
                bw.write(data.toString());
                bw.newLine();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
