package com.viveksb007.ds;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class JavaApiTest {

    @Test
    public void testInBuiltBinarySearch() {
        int[] arr = new int[]{2, 4, 6, 8, 10, 34, 56};
        int index = Arrays.binarySearch(arr, 8);
        assertEquals(3, index);
        index = Arrays.binarySearch(arr, 7);
        // if key is not found then index  = (-(insertion point) - 1)
        assertEquals(-4, index);
        System.out.println(index);
        index = Arrays.binarySearch(arr, -1);
        assertEquals(-1, index);
    }

}
