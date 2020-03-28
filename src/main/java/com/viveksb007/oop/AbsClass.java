package com.viveksb007.oop;

public abstract class AbsClass {

    void print() {
        System.out.println(getSomething());
    }

    abstract String getSomething();

}
