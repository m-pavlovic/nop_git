package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadFromTxtFile implements LoadStrategy {


    @Override
    public void checkIfFileExists() {
        if (!new File("calcData.txt").exists()) {
            new File("com/marijapavlovic/zadatak_1_1/data_save_load/calcData.txt");
        }

    }

    @Override
    public StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData){
        calcData.clear();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            String line;
            while ((line = br.readLine()) != null){
                calcData.add(parseCalcData(line));
                sb.append(line + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;

    }
    public CalcData parseCalcData(String personString){
        String[] calcData = personString.substring(personString.indexOf("{") + 1, personString.indexOf("}")).split(",");
        double firstNum = Double.parseDouble(calcData[0].split("=")[1]);
        double secondNum = Double.parseDouble(calcData[1].split("=")[1]);
        String operation = calcData[2].split("=")[1];
        double result = Double.parseDouble(calcData[3].split("=")[1]);
        return new CalcData(firstNum, secondNum, operation, result);
    }
}
