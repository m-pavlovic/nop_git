package com.marijapavlovic.zadatak_1_1;

import java.util.EventListener;

public interface CalculationPanelListener extends EventListener {
    void calculationEventOccurred(CalculationPanelEvent e);
}
