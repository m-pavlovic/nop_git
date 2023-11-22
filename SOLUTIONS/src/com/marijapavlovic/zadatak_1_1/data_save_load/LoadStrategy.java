package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.util.ArrayList;

public interface LoadStrategy {

    StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData);

    default String fileExtension(String path){
        return path.substring(path.lastIndexOf(".") + 1);
    }


}
