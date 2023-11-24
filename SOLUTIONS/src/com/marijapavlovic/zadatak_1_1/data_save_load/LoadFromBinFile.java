package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadFromBinFile implements LoadStrategy {

    @Override
    public StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData) {
        calcData.clear();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            while (true){
                CalcData data = (CalcData) ois.readObject();
                calcData.add(data);
                sb.append(data + "\n");
            }
        } catch (EOFException e){
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public String fileExtension(String path) {
        return LoadStrategy.super.fileExtension(path + ".bin");
    }
}
