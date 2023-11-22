package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.util.ArrayList;

public interface SaveStrategy {

    void saveToFile(String path, ArrayList<CalcData> calcData);

}
