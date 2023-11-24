package com.marijapavlovic.zadatak_1_1.data_save_load;

import com.marijapavlovic.zadatak_1_1.CalcData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadFromTxtFile implements LoadStrategy {


    @Override
    public StringBuffer loadFromFile(String path, ArrayList<CalcData> calcData){
        calcData.clear();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                if (line.trim().equals("======================================================================================")) {
                    continue;
                }
                calcData.add(parseCalcData(line));
                sb.append(line + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;

    }
    public CalcData parseCalcData(String dataString) {
        // Using regular expressions to find the relevant part
        Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(dataString);

        if (matcher.find()) {
            String calcDataString = matcher.group(1);
            String[] calcDataArray = calcDataString.split(",");

            double firstNum = Double.parseDouble(calcDataArray[0].split("=")[1]);
            double secondNum = Double.parseDouble(calcDataArray[1].split("=")[1]);
            String operation = calcDataArray[2].split("=")[1];
            double result = Double.parseDouble(calcDataArray[3].split("=")[1]);

            return new CalcData(firstNum, secondNum, operation, result);
        } else {
            throw new IllegalArgumentException("Invalid data format: " + dataString);
        }
    }
}
