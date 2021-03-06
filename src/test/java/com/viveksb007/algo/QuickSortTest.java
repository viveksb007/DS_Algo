package com.viveksb007.algo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void shouldBeAbleToSortArray() {
        int[] arr = new int[]{4, 6, 7, 2, 3, 4, 1, -5, 50, -6};
        QuickSort qSort = new QuickSort();
        qSort.sort(arr, arr.length);
        assertEquals(-6, arr[0]);
        assertEquals(-5, arr[1]);
        assertEquals(50, arr[9]);
    }

}
