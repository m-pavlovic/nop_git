package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import com.marijapavlovic.zadatak_1_2.Person;

import java.util.ArrayList;

public interface ReadWriteStrategy {


    StringBuffer loadFromFile(String path, ArrayList<Person> persons);

    void saveToFile(String path, ArrayList<Person> persons);
    default String fileExtension(String path){
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
