package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import com.marijapavlovic.zadatak_1_2.Person;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteBin implements ReadWriteStrategy {
    @Override
    public StringBuffer loadFromFile(String path, ArrayList<Person> persons) {
        // ensure that persons is empty
        persons.clear();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))){
            while (true){
                Person person = (Person) ois.readObject();
                persons.add(person);
                sb.append(person + "\n");
            }
        } catch (EOFException e){
            // end of file reached
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public void saveToFile(String path, ArrayList<Person> persons) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true))){
            for (Person person : persons){
                oos.writeObject(person);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
