package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;


import java.util.ArrayList;

public interface ReadWriteStrategy {


    <E> StringBuffer loadFromFile(String path, ArrayList<E> elements, Class<E> elementType);

    <E> void saveToFile(String path, ArrayList<E> elements);
    static String fileExtension(String path){
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
