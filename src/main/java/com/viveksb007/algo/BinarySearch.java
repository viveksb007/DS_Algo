package com.viveksb007.algo;

public class BinarySearch {

    public int search(int[] arr, int length, int target) {
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
