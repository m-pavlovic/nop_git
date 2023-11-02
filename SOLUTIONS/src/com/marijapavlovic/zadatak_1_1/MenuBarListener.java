package com.marijapavlovic.zadatak_1_1;

import java.util.EventListener;

public interface MenuBarListener extends EventListener {

    void loadEventOccurred(MenuBarEvent menuBarEvent);

    void saveEventOccurred(MenuBarEvent menuBarEvent);

    void exitEventOccurred(MenuBarEvent menuBarEvent);
}
