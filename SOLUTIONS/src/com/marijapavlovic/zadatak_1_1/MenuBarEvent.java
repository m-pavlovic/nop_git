package com.marijapavlovic.zadatak_1_1;

import java.awt.event.ActionListener;
import java.util.EventObject;


public class MenuBarEvent extends EventObject {

    private boolean loadItemClicked;
    private boolean saveItemClicked;
    private boolean exitItemClicked;

    public MenuBarEvent(Object source) {
        super(source);
        this.loadItemClicked = false;
        this.saveItemClicked = false;
        this.exitItemClicked = false;
    }
}
