package com.viveksb007.oop;

public final class InterfaceClass implements InterfaceA, InterfaceB {

    InterfaceClass() {
        see(this);
    }

    public static void main(String[] args) {
        final int i;
        i = 10;
        System.out.println(i);
        Dog d = new Dog("asdf");
        try {
            Dog e = (Dog) d.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("thrown exception");
        }
    }

    public static void main(String[] args, int n) {

    }

    private void see(InterfaceClass interfaceClass) {

    }

    @Override
    public void parentFunction() {

    }
}
