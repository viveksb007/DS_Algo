package com.viveksb007.lc;

import java.util.Arrays;

public class WiggleSort {

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int[] arr = new int[]{3, 5, 2, 1, 6, 4};
        ws.sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{5, 4, 3, 2, 1};
        ws.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 1; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
