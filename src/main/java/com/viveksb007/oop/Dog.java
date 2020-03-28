package com.viveksb007.oop;

import java.util.Objects;

public class Dog extends Animal implements Cloneable {

    private String type;

    Dog(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(type, dog.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
