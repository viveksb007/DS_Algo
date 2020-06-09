package com.viveksb007.lc;

import java.util.Arrays;

// https://leetcode.com/discuss/interview-question/424751/DE-Shaw-or-Coding-Round-Question-1

public class MinWater {

    public static void main(String[] args) {
        MinWater minWater = new MinWater();
        int[] water = new int[]{1, 2, 3};
        System.out.println(minWater.solve(water));
        System.out.println(minWater.solve(new int[]{1, 2, 3, 4, 100, 100, 100}));
    }

    private int solve(int[] water) {
        int totalWater = 0;
        int n = water.length;
        int i;
        for (i = 0; i < n; i++) totalWater += water[i];
        Arrays.sort(water);
        int minWater = Integer.MAX_VALUE;
        int waterRemoved = 0;
        for (i = 0; i < n; i++) {
            totalWater -= water[i];
            minWater = Math.min(minWater, waterRemoved + totalWater - ((n - i - 1) * water[i]));
            waterRemoved += water[i];
        }
        return minWater;
    }

}
