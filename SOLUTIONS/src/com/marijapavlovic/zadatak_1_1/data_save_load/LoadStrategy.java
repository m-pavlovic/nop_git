package com.marijapavlovic.zadatak_1_1.data_save_load;

public interface LoadStrategy {


    void checkIfFileExists();
    void loadFromFile();
}
