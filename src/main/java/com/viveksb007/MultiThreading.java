package com.viveksb007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MultiThreading {

    public static void main(String[] args) {
        MultiThreading multiThreading = new MultiThreading();
//        multiThreading.explore();
        multiThreading.testSingleThreadVSParallel();
    }

    private void testSingleThreadVSParallel() {
        int max = (int) Math.pow(10, 8);
        int[] arr = new int[max];
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            arr[i] = random.nextInt(100);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.stream(arr).limit(10).toArray()));
        System.out.println("Time for filling array " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.stream(arr).map(a -> a * 2).limit(10).toArray()));
        endTime = System.currentTimeMillis();
        System.out.println("Time for mapping on 1 thread " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(Arrays.stream(arr).parallel().map(a -> a * 2).limit(10).toArray()));
        endTime = System.currentTimeMillis();
        System.out.println("Time for mapping parallel " + (endTime - startTime) + " ms");
    }

    private void explore() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> callableTask = () -> {
            String start = String.valueOf(System.currentTimeMillis());
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getId());
            return start + " : " + System.currentTimeMillis();
        };
        Future<String> future = executorService.submit(callableTask);
        Future<String> future1 = executorService.submit(callableTask);
        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(callableTask);
        callableList.add(callableTask);

        try {
            List<Future<String>> futures = executorService.invokeAll(callableList);
            futures.forEach(f -> {
                try {
                    String response = f.get();
                    System.out.println(response);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}
