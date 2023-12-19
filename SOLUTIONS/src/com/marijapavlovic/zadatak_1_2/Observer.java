package com.marijapavlovic.zadatak_1_2;

import java.util.ArrayList;
import java.util.List;

public interface Observer {

    <E> void update(List<E> persons);

}
