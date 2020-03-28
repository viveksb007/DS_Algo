package com.viveksb007.oop;

public interface ParentInterface {
    String name = "parent";

    static String getName() {
        return name;
    }

    void parentFunction();
}
