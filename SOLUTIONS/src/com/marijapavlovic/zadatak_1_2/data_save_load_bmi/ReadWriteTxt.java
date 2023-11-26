package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import com.marijapavlovic.zadatak_1_2.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWriteTxt implements ReadWriteStrategy {

public static <E> E parseElementFromString(String elementString, Class<E> elementType) {
    Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
    Matcher matcher = pattern.matcher(elementString);

    if (matcher.find()) {
        String elementString1 = matcher.group(1);
        String[] elementArray = elementString1.split(",");

        float height = Float.parseFloat(elementArray[0].split("=")[1]);
        float weight = Float.parseFloat(elementArray[1].split("=")[1]);
        String category = elementArray[2].split("=")[1];
        float bmi = Float.parseFloat(elementArray[3].split("=")[1]);

        try {
            return elementType.getConstructor(float.class, float.class, String.class, float.class)
                    .newInstance(height, weight, category, bmi);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creating instance of type " + elementType, e);
        }
    } else {
        throw new IllegalArgumentException("Invalid data format: " + elementString);
    }
}

    @Override
    public <E> StringBuffer loadFromFile(String path, ArrayList<E> elements, Class<E> elementType) {
        elements.clear();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                E element = parseElementFromString(line, elementType);
                elements.add(element);
                sb.append(element).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public <E> void saveToFile(String path, ArrayList<E> elements) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true))) {
            for (E element : elements) {
                bw.write(element.toString());
                bw.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
