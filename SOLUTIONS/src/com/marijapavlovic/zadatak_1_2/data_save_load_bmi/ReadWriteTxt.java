package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import com.marijapavlovic.zadatak_1_2.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static Person parsePersonFromString(String personString){
        Pattern pattern = Pattern.compile("\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(personString);

        if (matcher.find()) {
            String peopleString = matcher.group(1);
            String[] peopleArray = peopleString.split(",");

            float height = Float.parseFloat(peopleArray[0].split("=")[1]);
            float weight = Float.parseFloat(peopleArray[1].split("=")[1]);
            String category = peopleArray[2].split("=")[1];
            float bmi = Float.parseFloat(peopleArray[3].split("=")[1]);

            return new Person(height, weight, category, bmi);
        } else {
            // Handle the case where the pattern is not found
            throw new IllegalArgumentException("Invalid data format: " + personString);
        }
    }
}
