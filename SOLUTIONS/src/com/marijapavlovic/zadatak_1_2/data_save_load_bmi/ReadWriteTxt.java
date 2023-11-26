package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import com.marijapavlovic.zadatak_1_2.Person;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteTxt implements ReadWriteStrategy {
    @Override
    public StringBuffer loadFromFile(String path, ArrayList<Person> persons) {
        // ensure that persons is empty
        persons.clear();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            String line;
            while ((line = br.readLine()) != null){
                persons.add(parsePersonFromString(line));
                sb.append(line + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public void saveToFile(String path, ArrayList<Person> persons) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true))){
            for (Person person : persons){
                bw.write(person.toString());
                bw.newLine();
            }
            //
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    static Person parsePersonFromString(String personString){
        // drop Person string and parentheses {}
        String[] personData = personString.substring(personString.indexOf("{") + 1, personString.indexOf("}")).split(",");
        float height = Float.parseFloat(personData[0].split("=")[1]);
        float weight = Float.parseFloat(personData[1].split("=")[1]);
        String category = personData[2].split("=")[1];
        float bmi = Float.parseFloat(personData[3].split("=")[1]);
        return new Person(height, weight, category, bmi);
    }
}
