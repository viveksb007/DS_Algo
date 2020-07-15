package com.viveksb007.lc;

public interface Cache {

    int get(int key);

    void put(int key, int value);

    int size();

}
