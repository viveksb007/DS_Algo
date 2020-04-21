package com.viveksb007.algo;

public class MergeSort {

    public void sort(int[] arr, int length) {
        mergeSort(arr, 0, length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int l1 = mid - left + 1;
        int l2 = right - mid;
        int[] lArr = new int[l1];
        int[] rArr = new int[l2];
        int i = 0, j = 0, k = left;
        for (i = 0; i < l1; i++) {
            lArr[i] = arr[i + left];
        }
        for (i = 0; i < l2; i++) {
            rArr[i] = arr[mid + 1 + i];
        }
        i = 0;
        while (i < l1 && j < l2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while (i < l1) {
            arr[k++] = lArr[i++];
        }
        while (j < l2) {
            arr[k++] = rArr[j++];
        }
    }

}
