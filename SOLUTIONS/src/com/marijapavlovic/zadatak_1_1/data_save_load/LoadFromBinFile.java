package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadFromBinFile implements LoadStrategy {
    @Override
    public void checkIfFileExists() {
        if (!new File("calcData.bin").exists()) {
            new File("com/marijapavlovic/zadatak_1_1/data_save_load/calcData.bin");
        }

    }

    @Override
    public StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData) {
        calcData.clear();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))){
            while (true){
                CalcData data = (CalcData) ois.readObject();
                calcData.add(data);
                sb.append(data + "\n");
            }
        } catch (EOFException e){
            // end of file reached
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public CalcData parseCalcData(String personString){
        String[] calcData = personString.substring(personString.indexOf("{") + 1, personString.indexOf("}")).split(",");
        double firstNum = Double.parseDouble(calcData[0].split("=")[1]);
        double secondNum = Double.parseDouble(calcData[1].split("=")[1]);
        String operation = calcData[2].split("=")[1];
        double result = Double.parseDouble(calcData[3].split("=")[1]);
        return new CalcData(firstNum, secondNum, operation, result);
    }

    @Override
    public String fileExtension(String path) {
        return LoadStrategy.super.fileExtension(path + ".bin");
    }
}
