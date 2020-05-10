package com.viveksb007;

import java.util.function.Predicate;

public class Functional {

    public static void main(String[] args) {
        Functional functional = new Functional();
        functional.test();
    }

    private void test() {
        thread();
        square();
        predicate();
    }

    private void predicate() {
        Predicate<String> p = (s) -> s.startsWith("yo");
        System.out.println(p.test("yoman"));
        System.out.println(p.test("noman"));
    }

    private void square() {
        Square s = () -> System.out.println("Square from lambda");
        s.compute();
    }

    private void thread() {
        new Thread(() -> System.out.println("New Thread")).start();
    }

    @FunctionalInterface
    interface Square {
        void compute();
    }

}
