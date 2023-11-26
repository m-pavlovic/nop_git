package com.marijapavlovic.zadatak_1_2.data_save_load_bmi;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteBin implements ReadWriteStrategy {

    @Override
    public <E> StringBuffer loadFromFile(String path, ArrayList<E> elements, Class<E> elementType) {
        elements.clear();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))){
            while (true){
                E element = (E) ois.readObject();
                elements.add(element);
                sb.append(element + "\n");
            }
        } catch (EOFException e){
            // end of file reached
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public <E> void saveToFile(String path, ArrayList<E> elements) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true))){
            for (E element : elements){
                oos.writeObject(element);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
