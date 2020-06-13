package com.viveksb007.gist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExp {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 34, 5);
        Stream<Integer> intStream = list.stream();
        Stream<Integer> filteredStream = intStream.filter(x -> x % 2 != 0);
        Stream<Integer> mappedStream = filteredStream.map(x -> {
            System.out.println(x);
            return 2 * x;
        });
        System.out.println("Before terminal operation called");
        System.out.println("Count " + mappedStream.count());

        complexityCheck();
//        infiniteStream();
//        infiniteOrderedStream();
    }

    private static void infiniteOrderedStream() {
        Stream<Integer> infiniteOrderedStream = Stream.iterate(Integer.MIN_VALUE, (i) -> i + 1);
        infiniteOrderedStream.forEach(System.out::println);
    }

    private static void infiniteRandomStream() {
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return random.nextInt(10);
        };
        Stream<Integer> infiniteStream = Stream.generate(supplier);
        infiniteStream.forEach(x -> {
            System.out.println("\n");
            System.out.println(Thread.currentThread().getId());
            System.out.println(x);
        });
    }

    private static void complexityCheck() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int n = (int) Math.pow(10, 7);
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(n));
        }

        long startTime = 0, endTime = 0;

        startTime = System.currentTimeMillis();
        List<Integer> resultList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) continue;
            resultList.add(integer * 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Result size " + resultList.size());
        System.out.println("Loop timing " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        List<Integer> resList = list.stream().filter(x -> x % 2 != 0).map(x -> 2 * x).collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Result size " + resList.size());
        System.out.println("Stream timing " + (endTime - startTime) + " ms");

        System.out.println(resultList.size());
        System.out.println(resList.size());
    }

}
