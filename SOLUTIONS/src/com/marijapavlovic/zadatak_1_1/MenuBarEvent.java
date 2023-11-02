package com.marijapavlovic.zadatak_1_1;

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

    private boolean isLoadItemClicked() {
        return loadItemClicked;
    }

    public void setLoadItemClicked(boolean loadItemClicked) {
        this.loadItemClicked = loadItemClicked;
    }

    private boolean isSaveItemClicked() {
        return saveItemClicked;
    }

    public void setSaveItemClicked(boolean saveItemClicked) {
        this.saveItemClicked = saveItemClicked;
    }

    private boolean isExitItemClicked() {
        return exitItemClicked;
    }

    public void setExitItemClicked(boolean exitItemClicked) {
        this.exitItemClicked = exitItemClicked;
    }
}
