package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveToBinFile implements SaveStrategy {


    @Override
    public void saveToFile(String path, ArrayList<CalcData> calcData){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true))){
            for (CalcData data : calcData){
                oos.writeObject(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
