package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.util.ArrayList;

public interface LoadStrategy {


    void checkIfFileExists();

    StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData);

    CalcData parseCalcData(String line);

    default String fileExtension(String path){
        return path.substring(path.lastIndexOf(".") + 1);
    }


}
