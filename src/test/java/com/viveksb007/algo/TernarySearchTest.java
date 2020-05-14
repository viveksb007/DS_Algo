package com.viveksb007.algo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TernarySearchTest {

    private TernarySearch ternarySearch;

    @BeforeClass
    public void setUp() {
        ternarySearch = new TernarySearch();
    }

    @Test
    public void shouldFindElementInArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 7, 10, 100};
        assertEquals(arr.length - 1, ternarySearch.search(arr, arr.length, 100));
    }

    @Test
    public void shouldReturnNegOne() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 7, 10, 100};
        assertEquals(-1, ternarySearch.search(arr, arr.length, 12));
    }

}
