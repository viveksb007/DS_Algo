package com.viveksb007.algo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void shouldBeAbleToFindElement() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch bSearch = new BinarySearch();
        assertEquals(4, bSearch.search(arr, arr.length, 5));
        assertEquals(0, bSearch.search(arr, arr.length, 1));
        assertEquals(-1, bSearch.search(arr, arr.length, 10));
        assertEquals(-1, bSearch.search(arr, arr.length, -20));
    }

}
